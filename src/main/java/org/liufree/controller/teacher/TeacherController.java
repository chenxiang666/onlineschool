package org.liufree.controller.teacher;

import org.liufree.bean.course.Course;
import org.liufree.bean.user.User;
import org.liufree.dao.course.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lwx
 * @date 6/6/17
 * @email liufreeo@gmail.com
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    CourseDao courseDao;

    @RequestMapping("/courses")
    public String courses(HttpSession session,Model model){
        int userId = (Integer) session.getAttribute("userId");
        List<Course> courseList = courseDao.getCoursesByUserId(userId);
        // List<Course> courseList = courseDao.findAll();
        model.addAttribute("courseList", courseList);
        return "teacher/teacher_courses";
    }

    @RequestMapping("/course/{courseId}")
    public String getCourseById(@PathVariable("courseId")int courseId, Model model,HttpSession session)
    {
        session.setAttribute("_courseId",courseId);
        Course course1 = courseDao.findOne(courseId);

        System.out.println(course1.getTitle());
        Course course = courseDao.getCourseById(courseId);
        model.addAttribute("course",course);
        System.out.println(course.getTitle());
        return "teacher/item_course";
    }



}
