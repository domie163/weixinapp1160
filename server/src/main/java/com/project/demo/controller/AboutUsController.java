package com.project.demo.controller;

import com.project.demo.entity.AboutUs;
import com.project.demo.service.AboutUsService;
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
 * 关于我们：(AboutUs)表控制层
 *
 */
@RestController
@RequestMapping("/about_us")
public class AboutUsController extends BaseController<AboutUs, AboutUsService> {

    /**
     * 关于我们对象
     */
    @Autowired
    public AboutUsController(AboutUsService service) {
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
