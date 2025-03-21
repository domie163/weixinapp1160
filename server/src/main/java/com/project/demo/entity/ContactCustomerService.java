package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 联系客服：(ContactCustomerService)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ContactCustomerService")
public class ContactCustomerService implements Serializable {

    // ContactCustomerService编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_customer_service_id")
    private Integer contact_customer_service_id;

    // 客服名称
    @Basic
    private String customer_service_name;
    // 联系电话
    @Basic
    private String contact_number;
    // 服务内容
    @Basic
    private String service_content;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
