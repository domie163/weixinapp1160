package com.project.demo.controller;

import com.project.demo.entity.RegisteredUsers;
import com.project.demo.service.RegisteredUsersService;
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
 * 注册用户：(RegisteredUsers)表控制层
 *
 */
@RestController
@RequestMapping("/registered_users")
public class RegisteredUsersController extends BaseController<RegisteredUsers, RegisteredUsersService> {

    /**
     * 注册用户对象
     */
    @Autowired
    public RegisteredUsersController(RegisteredUsersService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapuser_number = new HashMap<>();
        mapuser_number.put("user_number",String.valueOf(paramMap.get("user_number")));
        List listuser_number = service.select(mapuser_number, new HashMap<>()).getResultList();
        if (listuser_number.size()>0){
            return error(30000, "字段用户编号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
