package com.project.demo.controller;

import com.project.demo.entity.ClassifiedSales;
import com.project.demo.service.ClassifiedSalesService;
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
 * 分类销售额：(ClassifiedSales)表控制层
 *
 */
@RestController
@RequestMapping("/classified_sales")
public class ClassifiedSalesController extends BaseController<ClassifiedSales, ClassifiedSalesService> {

    /**
     * 分类销售额对象
     */
    @Autowired
    public ClassifiedSalesController(ClassifiedSalesService service) {
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
