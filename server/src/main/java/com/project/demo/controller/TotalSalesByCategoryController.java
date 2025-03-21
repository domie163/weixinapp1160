package com.project.demo.controller;

import com.project.demo.entity.TotalSalesByCategory;
import com.project.demo.service.TotalSalesByCategoryService;
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
 * 分类总销量：(TotalSalesByCategory)表控制层
 *
 */
@RestController
@RequestMapping("/total_sales_by_category")
public class TotalSalesByCategoryController extends BaseController<TotalSalesByCategory, TotalSalesByCategoryService> {

    /**
     * 分类总销量对象
     */
    @Autowired
    public TotalSalesByCategoryController(TotalSalesByCategoryService service) {
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
