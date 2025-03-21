package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 口味管理：(FlavorManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "FlavorManagement")
public class FlavorManagement implements Serializable {

    // FlavorManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flavor_management_id")
    private Integer flavor_management_id;

    // 口味类型
    @Basic
    private String flavor_type;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
