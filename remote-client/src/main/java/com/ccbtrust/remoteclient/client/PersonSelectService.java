package com.ccbtrust.remoteclient.client;

import com.ccbtrust.remoteclient.model.PersonSelectConditionsDTO;
import com.ccbtrust.remoteclient.model.PersonSelectResultDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * 查询员工
 * @author nzhang
 */
@FeignClient(value = "service-person")
public interface PersonSelectService {
    /**
     * 根据员工id查询员工
     * @param id 员工id
     * @return 返回根基id查询到的员工信息
     */
    @RequestMapping(value = "/select/selectById/{id}",method = RequestMethod.GET)
    PersonSelectResultDTO selectById(@PathVariable("id") int id);


    /**
     * 根据员工证件号码查询员工
     * @param cardNum 员工证件号码
     * @return 返回根基证件号码查询到的员工信息
     */
    @RequestMapping(value = "/select/selectByCardNum/{cardNum}",method = RequestMethod.GET)
    PersonSelectResultDTO selectByCardNum(@PathVariable("cardNum") String cardNum);


    /**
     * 分页查询所有员工
     * @param pageNum 页码
     * @param pageSize 每页显示的条数
     * @return 查询到的员工信息列表
     */
    @RequestMapping(value = "/select/selectAll/{pageNum}/{pageSize}",method = RequestMethod.GET)
    List<PersonSelectResultDTO> selectAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize);

    /**
     * 通过组合条件查询
     * @param personSelectConditionsDTO 查询条件
     * @return 返回查询结果
     */
    @RequestMapping(value = "/select/selectByConditions",method = RequestMethod.POST)
    List<PersonSelectResultDTO> selectByConditions(@RequestBody PersonSelectConditionsDTO personSelectConditionsDTO);


}
