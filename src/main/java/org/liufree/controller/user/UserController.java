package org.liufree.controller.user;


import org.liufree.bean.course.Course;
import org.liufree.bean.course.CourseModel;
import org.liufree.bean.course.Grade;
import org.liufree.bean.user.User;
import org.liufree.bean.user.UserCourse;
import org.liufree.bean.user.UserModel;
import org.liufree.common.Encode;
import org.liufree.dao.course.CourseDao;
import org.liufree.dao.course.GradeDao;
import org.liufree.dao.user.UserCourseDao;
import org.liufree.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Entity;
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
    public String register_user(User user, Model model,HttpSession session) {
        user.setUsername(user.getEmail());          ///name equals email
        user.setPassword("1111");
        userDao.save(user);
        int userId = userDao.findByEmailAndFirstName(user.getEmail(), user.getFirstName());
        List<Grade> gradeList = gradeDao.findAll();
        List<Course> courseList = courseDao.findAll();
        session.setAttribute("userId",userId);
        model.addAttribute("gradeList", gradeList);
        model.addAttribute("courseList", courseList);
        return "user/register_courses";
    }

    @RequestMapping(value = "/register_courses", method = RequestMethod.POST)
    public String register_courses(CourseModel courseModel, Model model,HttpSession session) {
        for (UserCourse userCourse : courseModel.getUserCourseList()) {
            if (userCourse.getCourseId() != 0) {
                userCourse.setUserId((Integer)session.getAttribute("userId"));
                userCourseDao.save(userCourse);
                System.out.println(userCourse.getId());
            }

        }
        System.out.println("刘文想");
        return "user/register_payment";
    }

    @RequestMapping("/register_payment")
    public String register_payment(HttpSession session,Model model) {
        int userId = (Integer)session.getAttribute("userId");
        System.out.println(userId);
        User user = userDao.findById(userId);
        model.addAttribute("user", user);
        return "user/register_finish";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession httpSession) {
        String username = user.getUsername();
        String password = user.getPassword();
       // user.setPassword(Encode.getMd5(password));
        User user1;
        if ((user1 = userDao.login(username, password)) != null) {
            httpSession.setAttribute("userId", user1.getId());
            httpSession.setAttribute("username",user1.getUsername());
            System.out.println(user1.getUsername());
            model.addAttribute("user", user1);
            List<Course> courseList = courseDao.getCoursesByUserId(user1.getId());
            model.addAttribute("courseList", courseList);
            return "user/user_courses";
        } else {
            return null;
        }
    }

    @RequestMapping("/courses")
    public String courses(Model model,HttpSession session){

        int userId = (Integer)session.getAttribute("userId");
        List<Course> courseList = courseDao.getCoursesByUserId(userId);
       // List<Course> courseList = courseDao.findAll();
        model.addAttribute("courseList", courseList);
        return "user/user_courses";
    }
    @RequestMapping("/information")
    public String information(HttpSession session,Model model){
        int userId = (Integer)session.getAttribute("userId");
        User user = userDao.findById(userId);
        model.addAttribute("user", user);
        return "user/user_information";
    }

    @RequestMapping("/message")
    public String message(){
        return "user/user_message";
    }
   /* @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String index(@PathVariable("id") int id, ModelMap modelMap) {
        User user = userDao.findOne(id);
        modelMap.addAttribute("user", user);
        return "common/index";
    }


    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "user/login";
    }


    @RequestMapping(value = "/toRegister")
    public String toRegister() {
        return "user/register";
    }

    @RequestMapping(value = "/toUpdate")
    public String toUpdate() {
        return "user/update";
    }

    @RequestMapping(value = "/toLogout")
    public String toLogout() {
        return "user/logout";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user, Model model) {
        String password = user.getPassword();
        user.setPassword(Encode.getMd5(password));
        userDao.save(user);     //存进数据库
        return "common/index";
    }

    @RequestMapping(value = "/logut")
    public String logut(HttpSession httpSession) {
        httpSession.getAttribute("username");
        return "common/index";
    }

    @RequestMapping(value = "/getUserList")
    public String getUserList(Model model) {

        List<User> userList;
        userList = userDao.findAll();
        model.addAttribute("userList", userList);
        return "user/getAllUser";
    }*/


}
