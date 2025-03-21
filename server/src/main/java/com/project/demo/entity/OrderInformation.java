package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 订单信息：(OrderInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "OrderInformation")
public class OrderInformation implements Serializable {

    // OrderInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_information_id")
    private Integer order_information_id;

    // 套餐名称
    @Basic
    private String package_name;
    // 口味
    @Basic
    private String flavor;
    // 套餐类型
    @Basic
    private String package_type;
    // 套餐价格
    @Basic
    private Integer package_price;
    // 商家名称
    @Basic
    private String merchant_name;
    // 订单编号
    @Basic
    private String order_number;
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
    // 购买时间
    @Basic
    private Timestamp purchase_time;
    // 标注说明
    @Basic
    private String annotation_notes;




    // 支付状态
    @Basic
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @Basic
    private String pay_type;










    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
