package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 订单状态：(OrderStatus)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "OrderStatus")
public class OrderStatus implements Serializable {

    // OrderStatus编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_status_id")
    private Integer order_status_id;

    // 订单编号
    @Basic
    private String order_number;
    // 菜品名称
    @Basic
    private String dish_name;
    // 用户编号
    @Basic
    private Integer user_number;
    // 姓名
    @Basic
    private String full_name;
    // 手机号码
    @Basic
    private String phone_number;
    // 收货地址
    @Basic
    private String shipping_address;
    // 记录时间
    @Basic
    private Timestamp record_time;
    // 订单状态
    @Basic
    private String order_status;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
