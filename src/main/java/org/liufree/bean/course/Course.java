package org.liufree.bean.course;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lwx
 * @date 5/10/17
 * @email liufreeo@gmail.com
 */
@Entity
@Data
@Table(name = "course")
public class Course {           //课程类

    @Id
    int courseId;

    int gradeId;            //所属年级id
    String title;           //标题
    String description;     //描述
    int type;               //课程类型
    String pic;             //课程图片
    double price;           //价格
    int buyCount;           //销售数量
    String creatTime;       //创建时间
    String updateTime;      //更新时间
}
