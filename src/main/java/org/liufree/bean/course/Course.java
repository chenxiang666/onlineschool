package org.liufree.bean.course;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int gradeId;            //所属年级id
    String title;           //标题
    String description;     //描述
    int type;               //课程类型
    String pic;             //课程图片
    double price;           //价格
    //  int buyCount;           //销售数量
    Date creatTime;       //创建时间
    Date updateTime;      //更新时间
    int teacherId;         //老师     就是userId
}
