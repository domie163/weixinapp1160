package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 分类总销量：(TotalSalesByCategory)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "TotalSalesByCategory")
public class TotalSalesByCategory implements Serializable {

    // TotalSalesByCategory编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "total_sales_by_category_id")
    private Integer total_sales_by_category_id;

    // 标题
    @Basic
    private String title;
    // 统计时间
    @Basic
    private String statistical_time;
    // 分类名称
    @Basic
    private String classification_name;
    // 总销量
    @Basic
    private Integer total_sales;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
