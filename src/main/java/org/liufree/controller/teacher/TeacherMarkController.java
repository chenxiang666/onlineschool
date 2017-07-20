package org.liufree.controller.teacher;

import org.liufree.bean.exam.*;
import org.liufree.bean.user.User;
import org.liufree.dao.exam.ExamDao;
import org.liufree.dao.exam.ExamResultDao;
import org.liufree.dao.exam.ExamResultQuestionDao;
import org.liufree.dao.exam.QuestionDao;
import org.liufree.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @Autowired
    ExamResultQuestionDao examResultQuestionDao;
    @Autowired
    QuestionDao questionDao;

    @RequestMapping("/markList")   //
    public String markList(HttpSession session, Model model) {
        int courseId = (Integer) session.getAttribute("_courseId");
        List<User> userList = userDao.findAll();
        List<ExamResult> examResultList = examResultDao.findByCourseId(courseId);
        List<Exam> examList = examDao.getExamsByCourseId(courseId);
        model.addAttribute("examList", examList);
        model.addAttribute("examResultList", examResultList);
        model.addAttribute("userList", userList);
        return "mark/teacher_marks";
    }

    @RequestMapping("/mark/{id}") //批改试卷  数据库设计有缺陷，不想改前面，这里。。。只能写的复杂点了
    public String markId(@PathVariable("id") int id, Model model) {
        ExamResult examResult = examResultDao.findOne(id);
        int userId = examResult.getUserId();
        int examId = examResult.getExamId();
        Exam exam = examDao.findOne(examId);
        System.out.println(exam.getTitle());
        List<Question> questionList = questionDao.getQuestionListByExamId(examId);
        List<ExamResultQuestion> examResultQuestionList = examResultQuestionDao.getByExamResultId(examResult.getId());
        model.addAttribute("examResultId", examResult.getId());
        model.addAttribute("exam", exam);
        model.addAttribute("questionList", questionList);
        model.addAttribute("examResultQuestionList", examResultQuestionList);
        return "mark/teacher_tomark";
    }

    @RequestMapping(value = "/correct/{examResultId}",method = RequestMethod.POST)
    public String correct(@PathVariable("examResultId")int examResultId, MarkModel markModel,HttpSession session) {
       double totalScore=0.0;

        for (ExamQuestion examQuestion : markModel.getExamQuestionList()) {
            totalScore+=examQuestion.getItemScore();
        }

        ExamResult examResult = examResultDao.findOne(examResultId);
        examResult.setStatus(1);
        examResult.setScore(totalScore);
        examResultDao.save(examResult);
        return "redirect:/teacher/mark/markList";
    }
}


