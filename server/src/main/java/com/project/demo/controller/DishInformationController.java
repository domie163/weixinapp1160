package com.project.demo.controller;

import com.project.demo.entity.DishInformation;
import com.project.demo.service.DishInformationService;
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
 * 菜品信息：(DishInformation)表控制层
 *
 */
@RestController
@RequestMapping("/dish_information")
public class DishInformationController extends BaseController<DishInformation, DishInformationService> {

    /**
     * 菜品信息对象
     */
    @Autowired
    public DishInformationController(DishInformationService service) {
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
