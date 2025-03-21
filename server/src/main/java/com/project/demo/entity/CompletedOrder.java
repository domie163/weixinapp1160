package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 已完成订单：(CompletedOrder)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CompletedOrder")
public class CompletedOrder implements Serializable {

    // CompletedOrder编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "completed_order_id")
    private Integer completed_order_id;

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
    // 完成时间
    @Basic
    private Timestamp completion_time;
    // 备注
    @Basic
    private String remarks;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
