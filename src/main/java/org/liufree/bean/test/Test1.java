package org.liufree.bean.test;

import lombok.Data;
import org.liufree.bean.course.Course;
import org.liufree.bean.course.Grade;
import org.liufree.bean.exam.Exam;
import org.liufree.bean.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lwx
 * @date 7/20/17
 * @email liufreeo@gmail.com
 */
@Data
@Entity
@Table(name = "test1")
public class Test1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String password;

    @OneToOne
    User user;

    // default fetch mode is lazy.
    @ManyToMany
    List<Course> courseList = new ArrayList<Course>();

    @OneToMany
    List<Grade> gradeList = new ArrayList<Grade>();

    @ManyToOne
    Exam exam;
}
