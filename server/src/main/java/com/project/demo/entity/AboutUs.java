package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 关于我们：(AboutUs)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AboutUs")
public class AboutUs implements Serializable {

    // AboutUs编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "about_us_id")
    private Integer about_us_id;

    // 标题
    @Basic
    private String title;
    // 发布时间
    @Basic
    private Timestamp release_time;
    // 详情介绍
    @Basic
    private String detailed_introduction;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
