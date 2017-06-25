package org.liufree.controller.course;

import org.liufree.bean.course.Course;
import org.liufree.bean.course.CourseFile;
import org.liufree.bean.course.CourseUnit;
import org.liufree.bean.course.Grade;
import org.liufree.bean.exam.Exam;
import org.liufree.bean.user.UserCourse;
import org.liufree.dao.course.CourseDao;
import org.liufree.dao.course.CourseFileDao;
import org.liufree.dao.course.CourseUnitDao;
import org.liufree.dao.course.GradeDao;
import org.liufree.dao.exam.ExamDao;
import org.liufree.dao.user.UserCourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    UserCourseDao userCourseDao;
    @Autowired
    CourseUnitDao courseUnitDao;
    @Autowired
    GradeDao gradeDao;
    @Autowired
    ExamDao examDao;
    @Autowired
    CourseFileDao courseFileDao;

    @RequestMapping("/grade/{gradeId}")
    public String getCoursesByGrade(@PathVariable("gradeId") int gradeId, Model model) {
        List<Grade> gradeList = gradeDao.findAll();
        List<Course> courseList = courseDao.findAll();
        model.addAttribute("gradeList", gradeList);
        model.addAttribute("courseList", courseList);

        return "course/courses_grade";
    }

    @RequestMapping("/course/{courseId}")
    public String getCourseById(@PathVariable("courseId") int courseId, Model model,HttpSession session) {
        Course course1 = courseDao.findOne(courseId);
        System.out.println(course1.getTitle());
        Course course = courseDao.getCourseById(courseId);
        List<CourseUnit> courseUnitList = courseUnitDao.getCourseUnitListByCourseId(courseId);
        List<CourseFile> courseFileList = courseFileDao.findAll();
        List<Exam> examList = examDao.getExamsByCourseId(courseId);
        model.addAttribute("examList", examList);
        model.addAttribute("courseFileList", courseFileList);
        model.addAttribute("courseUnitList", courseUnitList);
        model.addAttribute("course",course);
        session.setAttribute("_courseId",courseId);
        return "exam/item_course";
    }

    @RequestMapping("/course/detail/{courseId}")
    public String courseDetail(@PathVariable("courseId") int courseId, Model model) {

        List<Grade> gradeList = gradeDao.findAll();
        model.addAttribute("gradeList", gradeList);
        List<Course> courseList = courseDao.findAll();
        model.addAttribute("courseList", courseList);
        Course course = courseDao.findOne(courseId);

        List<CourseUnit> courseUnitList = courseUnitDao.getCourseUnitListByCourseId(courseId);
        model.addAttribute("course", course);
        model.addAttribute("courseUnitList", courseUnitList);
        return "course/course_detail";
    }

    @RequestMapping("/course/register/{courseId}")
    public String register(@PathVariable("courseId")int courseId, HttpSession session,Model model){
        String username = (String)session.getAttribute("username");
        if (username != null) {                 //登录之后这样处理
            int userId = (Integer)session.getAttribute("userId");
            UserCourse userCourse =new UserCourse();
            userCourse.setUserId(userId);
            userCourse.setCourseId(courseId);
            userCourseDao.save(userCourse);
            return "redirect:/course/"+courseId;
        }
        return "redirect:/register";
    }
}
