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
@Data
@Entity
@Table(name = "course_unit")
public class CourseUnit {           //课程单元类

    @Id
    int unitId;

    int courseId;           //所属课程Id
    String title;           //标题
    String detail;          //描述
    String creatTime;       //创建时间
    String updatetime;      //更改时间

}
