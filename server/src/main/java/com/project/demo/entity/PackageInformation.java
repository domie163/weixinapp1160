package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 套餐信息：(PackageInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PackageInformation")
public class PackageInformation implements Serializable {

    // PackageInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_information_id")
    private Integer package_information_id;

    // 套餐名称
    @Basic
    private String package_name;
    // 封面
    @Basic
    private String cover;
    // 口味
    @Basic
    private String flavor;
    // 原材料
    @Basic
    private String raw_material;
    // 套餐类型
    @Basic
    private String package_type;
    // 套餐价格
    @Basic
    private Integer package_price;
    // 商家名称
    @Basic
    private String merchant_name;
    // 联系电话
    @Basic
    private String contact_number;
    // 详情描述
    @Basic
    private String detailed_description;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;












    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
