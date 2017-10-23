package org.liufree.controller.common;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.liufree.bean.course.Course;
import org.liufree.bean.course.Grade;
import org.liufree.bean.test.Test1;
import org.liufree.bean.user.User;
import org.liufree.dao.course.CourseDao;
import org.liufree.dao.course.GradeDao;
import org.liufree.dao.test.TestDao;
import org.liufree.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author lwx
 * @date 5/5/17
 * @email liufreeo@gmail.com
 */
@Controller
public class IndexController {

    @Autowired
    GradeDao gradeDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    UserDao userDao;
    @Autowired
    TestDao testDao;
    Gson gson = new Gson();

    @RequestMapping("/")
    public String index(HttpSession session) {
        Test1 test1 = testDao.findOne(1);
        String kk = test1.getUser().getUsername();
        System.out.println(kk);

        System.out.println("OnlineSchool Success Operation");
        session.setAttribute("username", null);
        return "common/index";
    }

    @RequestMapping("/register")
    public String register() {
        return "user/register";
    }

    @RequestMapping("/school")
    public String school() {
        return "common/school";
    }

    @RequestMapping("/courses")
    public String courses(Model model) {
        List<Grade> gradeList = gradeDao.findAll();
        model.addAttribute("gradeList", gradeList);
        List<Course> courseList = courseDao.findAll();
        model.addAttribute("courseList", courseList);
        List<User> userList = userDao.findAll();
        model.addAttribute("userList", userList);
        return "course/index";
    }

    @RequestMapping("/faq")
    public String faq() {
        return "common/faq";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "common/contact";
    }

    @RequestMapping(value = "/getGrade")      //TOdo 通过ajax获得gradelist
    public void gradeList(HttpServletResponse response, HttpServletRequest request) {
        List<Grade> gradeList = gradeDao.findAll();
        String jsonResult = gson.toJson(gradeList);
        System.out.println(jsonResult);
        try {
            //设置页面不缓存
            response.setContentType("json");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = null;
            out = response.getWriter();
            out.print(jsonResult);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
