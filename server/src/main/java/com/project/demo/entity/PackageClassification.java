package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 套餐分类：(PackageClassification)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PackageClassification")
public class PackageClassification implements Serializable {

    // PackageClassification编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_classification_id")
    private Integer package_classification_id;

    // 分类名称
    @Basic
    private String classification_name;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
