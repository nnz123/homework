package com.ccbtrust.serviceperson.service;


import com.ccbtrust.remoteclient.model.PersonInsertDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Map;

/**
 * @author nzhang
 */
public interface PersonInsertService {
    /**
     * 增加员工
     * @param  personInsertDTO 员工信息
     * @return 反回插入的行数
     *
     */
     Map<String,Object> insert(PersonInsertDTO personInsertDTO);

    /**
     * 通过id删除员工
     * @param id 员工id
     */
    void deleteById(int id);



}
