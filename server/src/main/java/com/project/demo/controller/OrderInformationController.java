package com.project.demo.controller;

import com.project.demo.entity.OrderInformation;
import com.project.demo.service.OrderInformationService;
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
 * 订单信息：(OrderInformation)表控制层
 *
 */
@RestController
@RequestMapping("/order_information")
public class OrderInformationController extends BaseController<OrderInformation, OrderInformationService> {

    /**
     * 订单信息对象
     */
    @Autowired
    public OrderInformationController(OrderInformationService service) {
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
