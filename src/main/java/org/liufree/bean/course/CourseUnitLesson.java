package org.liufree.bean.course;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lwx
 * @date 5/28/17
 * @email liufreeo@gmail.com
 */
@Entity
@Table(name = "course_unit_lesson")
@Data
public class CourseUnitLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int unitId;                 //unitId
    String title;
    String description;

}
