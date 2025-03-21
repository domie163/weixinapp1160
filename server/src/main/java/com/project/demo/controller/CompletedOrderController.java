package com.project.demo.controller;

import com.project.demo.entity.CompletedOrder;
import com.project.demo.service.CompletedOrderService;
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
 * 已完成订单：(CompletedOrder)表控制层
 *
 */
@RestController
@RequestMapping("/completed_order")
public class CompletedOrderController extends BaseController<CompletedOrder, CompletedOrderService> {

    /**
     * 已完成订单对象
     */
    @Autowired
    public CompletedOrderController(CompletedOrderService service) {
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
