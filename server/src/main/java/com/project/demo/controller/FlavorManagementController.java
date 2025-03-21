package com.project.demo.controller;

import com.project.demo.entity.FlavorManagement;
import com.project.demo.service.FlavorManagementService;
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
 * 口味管理：(FlavorManagement)表控制层
 *
 */
@RestController
@RequestMapping("/flavor_management")
public class FlavorManagementController extends BaseController<FlavorManagement, FlavorManagementService> {

    /**
     * 口味管理对象
     */
    @Autowired
    public FlavorManagementController(FlavorManagementService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
