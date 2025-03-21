package com.project.demo.controller;

import com.project.demo.entity.Staff;
import com.project.demo.service.StaffService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 员工：(Staff)表控制层
 *
 */
@RestController
@RequestMapping("/staff")
public class StaffController extends BaseController<Staff, StaffService> {

    /**
     * 员工对象
     */
    @Autowired
    public StaffController(StaffService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapemployee_id = new HashMap<>();
        mapemployee_id.put("employee_id",String.valueOf(paramMap.get("employee_id")));
        List listemployee_id = service.select(mapemployee_id, new HashMap<>()).getResultList();
        if (listemployee_id.size()>0){
            return error(30000, "字段员工编号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
