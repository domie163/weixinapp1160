package com.project.demo.controller;

import com.project.demo.entity.PackageClassification;
import com.project.demo.service.PackageClassificationService;
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
 * 套餐分类：(PackageClassification)表控制层
 *
 */
@RestController
@RequestMapping("/package_classification")
public class PackageClassificationController extends BaseController<PackageClassification, PackageClassificationService> {

    /**
     * 套餐分类对象
     */
    @Autowired
    public PackageClassificationController(PackageClassificationService service) {
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
