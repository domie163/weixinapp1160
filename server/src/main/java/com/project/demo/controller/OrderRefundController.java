package com.project.demo.controller;

import com.project.demo.entity.OrderRefund;
import com.project.demo.service.OrderRefundService;
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
 * 订单退款：(OrderRefund)表控制层
 *
 */
@RestController
@RequestMapping("/order_refund")
public class OrderRefundController extends BaseController<OrderRefund, OrderRefundService> {

    /**
     * 订单退款对象
     */
    @Autowired
    public OrderRefundController(OrderRefundService service) {
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
