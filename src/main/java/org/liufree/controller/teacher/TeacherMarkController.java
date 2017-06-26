package org.liufree.controller.teacher;

import org.liufree.bean.exam.Exam;
import org.liufree.bean.exam.ExamResult;
import org.liufree.bean.user.User;
import org.liufree.dao.exam.ExamDao;
import org.liufree.dao.exam.ExamResultDao;
import org.liufree.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lwx
 * @date 6/26/17
 * @email liufreeo@gmail.com
 */
@Controller
@RequestMapping("/teacher/mark")
public class TeacherMarkController {
    @Autowired
    ExamResultDao examResultDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ExamDao examDao;

    @RequestMapping("/markList")
    public String markList(HttpSession session,Model model) {
        int courseId = (Integer) session.getAttribute("_courseId");
        List<User> userList = userDao.findAll();
        List<ExamResult> examResultList = examResultDao.findByCourseId(courseId);
        List<Exam> examList = examDao.getExamsByCourseId(courseId);
        model.addAttribute("examList", examList);
        model.addAttribute("examResultList", examResultList);
        model.addAttribute("userList", userList);
        return "mark/teacher_marks";
    }

    @RequestMapping("/mark/{id}") //批改试卷
    public String markId(@PathVariable("id") int id, HttpSession session, Model model) {
            return null;
    }

}

