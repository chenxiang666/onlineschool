package org.liufree.controller.user;


import org.liufree.bean.course.Course;
import org.liufree.bean.course.CourseModel;
import org.liufree.bean.course.Grade;
import org.liufree.bean.user.User;
import org.liufree.bean.user.UserCourse;
import org.liufree.dao.course.CourseDao;
import org.liufree.dao.course.GradeDao;
import org.liufree.dao.user.UserCourseDao;
import org.liufree.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lwx
 * @date 5/5/17
 * @email liufreeo@gmail.com
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserDao userDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    UserCourseDao userCourseDao;
    @Autowired
    GradeDao gradeDao;

    @RequestMapping(value = "/register_user", method = RequestMethod.POST)
    public String register_user(User user, Model model, HttpSession session) {
        user.setUsername(user.getEmail());          ///name equals email
        user.setPassword("1111");
        userDao.save(user);
        int userId = userDao.findByEmailAndFirstName(user.getEmail(), user.getFirstName());
        List<Grade> gradeList = gradeDao.findAll();
        List<Course> courseList = courseDao.findAll();
        session.setAttribute("userId", userId);
        model.addAttribute("gradeList", gradeList);
        model.addAttribute("courseList", courseList);
        return "user/register_courses";
    }

    @RequestMapping(value = "/register_courses", method = RequestMethod.POST)
    public String register_courses(CourseModel courseModel, Model model, HttpSession session) {
        for (UserCourse userCourse : courseModel.getUserCourseList()) {
            if (userCourse.getCourseId() != 0) {
                userCourse.setUserId((Integer) session.getAttribute("userId"));
                userCourseDao.save(userCourse);
                System.out.println(userCourse.getId());
            }

        }
        return "user/register_payment";
    }

    @RequestMapping("/register_payment")
    public String register_payment(HttpSession session, Model model) {
        int userId = (Integer) session.getAttribute("userId");
        System.out.println(userId);
        User user = userDao.findById(userId);
        model.addAttribute("user", user);
        return "user/register_finish";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session) {
        String username = user.getUsername();
        String password = user.getPassword();
        // user.setPassword(Encode.getMd5(password));
        User user1;
        if ((user1 = userDao.login(username, password)) != null) {
            session.setAttribute("role",user1.getRole());
            session.setAttribute("userId", user1.getId());
            session.setAttribute("username", user1.getUsername());
            System.out.println(user1.getUsername());
            model.addAttribute("user", user1);

            if (user1.getRole() == 0) {//学生
                List<Course> courseList = courseDao.getCoursesByUserId(user1.getId());
                model.addAttribute("courseList", courseList);
                return "user/user_courses";
            } else if(user1.getRole()==1){//老师
                List<Course> courseList = courseDao.getCoursesByTeacherId(user1.getId());
                model.addAttribute("courseList", courseList);
                return "teacher/teacher_courses";
            }
            else{
                return "principal/teachers";
            }
        } else {
            return null;
        }

    }

    @RequestMapping("/courses")
    public String courses(Model model, HttpSession session) {

        int userId = (Integer) session.getAttribute("userId");
        List<Course> courseList = courseDao.getCoursesByUserId(userId);
        // List<Course> courseList = courseDao.findAll();
        model.addAttribute("courseList", courseList);
        return "user/user_courses";
    }

    @RequestMapping("/information")
    public String information(HttpSession session, Model model) {
        int userId = (Integer) session.getAttribute("userId");
        User user = userDao.findById(userId);
        model.addAttribute("user", user);
        return "user/user_information";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userId");
        session.removeAttribute("username");
        session.removeAttribute("role");
        return "redirect:/";
    }

    @RequestMapping("/homework")
    public String getHomework(){
        return "user/user_homework";
    }

}
