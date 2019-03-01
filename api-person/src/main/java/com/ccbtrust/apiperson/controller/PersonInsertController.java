package com.ccbtrust.apiperson.controller;

import com.ccbtrust.apiperson.model.PersonInsertVO;
import com.ccbtrust.remoteclient.client.PersonInsertService;
import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import com.ccbtrust.remoteclient.util.ImageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nzhang
 */
@RestController
public class PersonInsertController {

    @Autowired
    private PersonInsertService personInsertService;


    /**
     * 添加员工共信息并上传图片 参数为request
     * @param mImage 上传的图像
     * @param personInsertVO  插入员工的VO
     * @return 返回操作是否成功等信息
     */
    @ApiOperation("添加员工信息")
    @RequestMapping(value = "/person/insert", method = RequestMethod.POST)
    public Map<String, Object> insert(@ApiParam("上传的头像") @RequestParam(value = "mImage") MultipartFile mImage,@ApiParam("员工基本信息personName,cardType, cardNum,phoneNum") PersonInsertVO personInsertVO) {
        Map<String, Object> map = new HashMap<>(16);
        String imageName = mImage.getOriginalFilename();
        String localImageAddr = ImageUtil.generateImageAddr(imageName);
        File file = new File(localImageAddr);
        try {
            mImage.transferTo(file);
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "照片存储本地失败");
            return map;
        }
        PersonInsertDTO personInsertDTO = new PersonInsertDTO();
        //添加用户基础信息
        if (personInsertVO != null) {
            personInsertDTO.setPersonName(personInsertVO.getPersonName());
            personInsertDTO.setCardType(personInsertVO.getCardType());
            personInsertDTO.setCardNum(personInsertVO.getCardNum());
            personInsertDTO.setPhoneNum(personInsertVO.getPhoneNum());
            personInsertDTO.setPersonPicture(localImageAddr);
            personInsertDTO.setCreatePerson("Nancy");
            try {
                personInsertService.insert(personInsertDTO);
            } catch (Exception e) {
                map.put("success", false);
                map.put("message", e.toString());
                return map;
            }
        }
        map.put("success", true);
        map.put("message", "添加person成功");
        return map;
    }



    /**
     * 添加员工共信息并上传图片 参数为request
     * @param request 前台传来的请求
     * @return 返回操作是否成功等信息
     */
  /*  @RequestMapping(value = "/person/insert", method = RequestMethod.POST)
    public Map<String, Object> insert(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(16);
        MultipartFile mImage = null;
        if (request.getContentType().toLowerCase().startsWith("multipart/")) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            mImage = multipartHttpServletRequest.getFile("mImage");
        } else {
            map.put("success", false);
            map.put("message", "照片没上传");
            return map;
        }
        String imageName = mImage.getOriginalFilename();
        String localImageAddr = ImageUtil.generateImageAddr(imageName);
        File file = new File(localImageAddr);
        try {
            mImage.transferTo(file);
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "照片存储本地失败");
        }
        PersonInsertDTO personInsertDTO = new PersonInsertDTO();
        //添加用户基础信息
        personInsertDTO.setPersonName(request.getParameter("personName"));
        personInsertDTO.setCardType(Integer.decode(request.getParameter("cardType")));
        personInsertDTO.setCardNum(request.getParameter("cardNum"));
        personInsertDTO.setPhoneNum(request.getParameter("phoneNum"));
        personInsertDTO.setPersonPicture(localImageAddr);
        try {
            personClientService.insert(personInsertDTO);
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "调用feignClient失败" + e.toString());
            return map;
        }
        map.put("success", true);
        map.put("message", "添加person成功");
        return map;
    }
*/
}
