package com.project.demo.controller;

import com.project.demo.entity.ContactCustomerService;
import com.project.demo.service.ContactCustomerServiceService;
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
 * 联系客服：(ContactCustomerService)表控制层
 *
 */
@RestController
@RequestMapping("/contact_customer_service")
public class ContactCustomerServiceController extends BaseController<ContactCustomerService, ContactCustomerServiceService> {

    /**
     * 联系客服对象
     */
    @Autowired
    public ContactCustomerServiceController(ContactCustomerServiceService service) {
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
