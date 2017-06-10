package org.liufree.bean.course;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lwx
 * @date 5/10/17
 * @email liufreeo@gmail.com
 */
@Data
@Entity
@Table(name = "course_unit")
public class CourseUnit {           //课程单元类

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int courseId;           //所属课程Id
    String title;           //标题
    String description;          //描述
    String spendTime;           //花费时间
    Date creatTime;       //创建时间
    Date updatetime;      //更改时间

}
