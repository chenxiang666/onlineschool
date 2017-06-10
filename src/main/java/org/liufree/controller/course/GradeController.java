package org.liufree.controller.course;

import org.liufree.bean.course.Course;
import org.liufree.bean.course.Grade;
import org.liufree.dao.course.CourseDao;
import org.liufree.dao.course.GradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.soap.Addressing;
import java.util.List;

/**
 * @author lwx
 * @date 5/30/17
 * @email liufreeo@gmail.com
 */
@Controller
public class GradeController {

    @Autowired
    GradeDao gradeDao;
    @Autowired
    CourseDao courseDao;

    public void index() {

    }

    public String getGradeList(Model model) {
        List<Grade> gradeList = gradeDao.findAll();
        model.addAttribute("gradeList", gradeList);
        return null;
    }

    //Todo 本来应该用ajax动态生成这几个请求
    //这个类有很多重复，需要修改

    //参数是gradeId

    @RequestMapping("/grade/grade9")
    public String grade9(Model model) {
        List<Grade> gradeList = gradeDao.findAll();
        model.addAttribute("gradeList", gradeList);
        List<Course> courseList = courseDao.findAll();
        model.addAttribute("courseList", courseList);
        Grade grade = gradeDao.findOne(1);
        model.addAttribute("_grade", grade);
        return "course/courses_grade";
    }

    @RequestMapping("/grade/grade10")
    public String grade10(Model model) {
        List<Grade> gradeList = gradeDao.findAll();
        model.addAttribute("gradeList", gradeList);
        List<Course> courseList = courseDao.findAll();
        model.addAttribute("courseList", courseList);
        Grade grade = gradeDao.findOne(2);
        model.addAttribute("_grade", grade);
        return "course/courses_grade";
    }

    @RequestMapping("/grade/grade11")
    public String grade11(Model model) {
        List<Grade> gradeList = gradeDao.findAll();
        model.addAttribute("gradeList", gradeList);
        List<Course> courseList = courseDao.findAll();
        model.addAttribute("courseList", courseList);
        Grade grade = gradeDao.findOne(3);
        model.addAttribute("_grade", grade);
        return "course/courses_grade";
    }

    @RequestMapping("/grade/gradebycourse/{gradeId}")
    public String course_grade(Model model, @PathVariable("gradeId")int gradeId) {
        List<Grade> gradeList = gradeDao.findAll();
        model.addAttribute("gradeList", gradeList);
        List<Course> courseList = courseDao.findAll();
        model.addAttribute("courseList", courseList);
        Grade grade = gradeDao.findOne(gradeId);
        model.addAttribute("_grade", grade);
        return "course/courses_grade";
    }
}
