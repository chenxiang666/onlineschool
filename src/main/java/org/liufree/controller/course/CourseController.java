package org.liufree.controller.course;

import org.liufree.bean.course.Course;
import org.liufree.bean.course.Grade;
import org.liufree.dao.course.CourseDao;
import org.liufree.dao.course.GradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lwx
 * @date 6/2/17
 * @email liufreeo@gmail.com
 */
@Controller
public class CourseController {

    @Autowired
    CourseDao courseDao;
    @Autowired
    GradeDao gradeDao;

    @RequestMapping("/grade/{gradeId}")
    public String getCoursesByGrade(@PathVariable("gradeId")int gradeId,Model model){
        List<Grade> gradeList = gradeDao.findAll();
        List<Course> courseList = courseDao.findAll();
        model.addAttribute("gradeList", gradeList);
        model.addAttribute("courseList", courseList);

        return "course/courses_grade";
    }

    @RequestMapping("/course/{courseId}")
    public String getCourseById(@PathVariable("courseId")int courseId,Model model)
    {
        Course course1 = courseDao.findOne(courseId);
        System.out.println(course1.getTitle());
        Course coure = courseDao.getCourseById(courseId);
        System.out.println(coure.getTitle());
        return "course/item_course";
    }

}
