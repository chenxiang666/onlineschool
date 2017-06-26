package org.liufree.controller.principal;
import org.liufree.bean.course.Course;
import org.liufree.bean.user.User;
import org.liufree.dao.course.CourseDao;
import org.liufree.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * Created by hama on 2017/6/25.
 */

@Controller
@RequestMapping("/principal")
public class PrincipalController {
    @RequestMapping("/courses")
    public String courses(HttpSession session,Model model){

        return "principal/courses";
    }
    @RequestMapping("/teachers")
    public String teachers(HttpSession session,Model model){

        return "principal/teachers";
    }
    @RequestMapping("/students")
    public String students(HttpSession session,Model model){

        return "principal/students";
    }
    @RequestMapping("/addTeacher")
    public String addTeacher(HttpSession session,Model model){

        return "principal/addTeacher";
    }
    @RequestMapping("/addCourse")
    public String addCourse(HttpSession session,Model model){

        return "principal/addcourse";
    }
    @RequestMapping("/changeCourse")
    public String changeCourse(HttpSession session,Model model){

        return "principal/changeCourse";
    }
    @RequestMapping("/changeTeacherInformation")
    public String changeTeacherInformation(HttpSession session,Model model){

        return "principal/changeTeacherInformation";
    }
    @RequestMapping("/studentInformation")
    public String studentInformation(HttpSession session,Model model){

        return "principal/studentInformation";
    }
}
