package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 订单退款：(OrderRefund)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "OrderRefund")
public class OrderRefund implements Serializable {

    // OrderRefund编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_refund_id")
    private Integer order_refund_id;

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
    // 申请时间
    @Basic
    private Timestamp application_time;
    // 申请原因
    @Basic
    private String reason_for_application;



    // 审核状态
    @Basic
    private String examine_state;








    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
