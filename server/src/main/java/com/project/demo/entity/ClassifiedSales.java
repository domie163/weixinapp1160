package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 分类销售额：(ClassifiedSales)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ClassifiedSales")
public class ClassifiedSales implements Serializable {

    // ClassifiedSales编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classified_sales_id")
    private Integer classified_sales_id;

    // 标题
    @Basic
    private String title;
    // 统计时间
    @Basic
    private String statistical_time;
    // 分类名称
    @Basic
    private String classification_name;
    // 总销售额
    @Basic
    private Integer total_sales_revenue;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
