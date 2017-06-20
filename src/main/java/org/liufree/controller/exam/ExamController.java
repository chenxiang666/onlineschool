package org.liufree.controller.exam;

import org.liufree.bean.exam.Exam;
import org.liufree.bean.exam.ExamQuestion;
import org.liufree.bean.exam.ExamQuestionModel;
import org.liufree.bean.exam.Question;
import org.liufree.dao.exam.ExamDao;
import org.liufree.dao.exam.ExamQuestionDao;
import org.liufree.dao.exam.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Action;
import java.util.List;

/**
 * @author lwx
 * @date 6/9/17
 * @email liufreeo@gmail.com
 */
@Controller
public class ExamController {

    @Autowired
    ExamDao examDao;
    @Autowired
    QuestionDao questionDao;
    @Autowired
    ExamQuestionDao examQuestionDao;

    @RequestMapping("/examList")
    public String examList(HttpSession session,Model model) {
        int courseId = (Integer)session.getAttribute("_courseId");
        List<Exam> examList = examDao.getExamsByCourseId(courseId);
        model.addAttribute("examList", examList);
        return "teacher/teacher_test";
    }

    @RequestMapping("/exam/{examId}")
    public String getExamById(@PathVariable("examId") int examId, Model model) {
        Exam exam = examDao.findOne(examId);
        model.addAttribute("exam", exam);
        List<ExamQuestion> examQuestionList = examQuestionDao.getQuestionByExamId(examId);
        model.addAttribute("examQuestionList", examQuestionList);
        List<Question> questionList = questionDao.getQuestionListByExamId(examId);
        model.addAttribute("questionList", questionList);
        return "exam/teacher_itemExam";
    }

    @RequestMapping("/exam/addPage")
    public String addPage(HttpSession session,Model model){
        int courseId = (Integer) session.getAttribute("_courseId");
        System.out.println(courseId);
       List<Question> questionList = questionDao.getQuestionListByCourseId(courseId);
        model.addAttribute("questionList", questionList);
        return "teacher/teacher_test_add";
    }

    @RequestMapping("/exam/add")
    public String add(HttpSession session,ExamQuestionModel examQuestionModel) {
        int courseId = (Integer) session.getAttribute("_courseId");
        Exam exam = examQuestionModel.getExam();
        exam.setCourseId(courseId);
        exam=examDao.save(exam);  //存了之后返回这个对象
        int examId=exam.getId();
        for (ExamQuestion examQuestion : examQuestionModel.getExamQuestionList()) {
            examQuestion.setExamId(examId);
            examQuestionDao.save(examQuestion);
        }


        return "redirect:/examList";
    }

    @RequestMapping("/exam/selectPage")
    public String selectPage(HttpSession session, Model model, Exam exam) {
        int courseId = (Integer) session.getAttribute("_courseId");
        exam.setCourseId(courseId);
        session.setAttribute("exam", exam);
        List<Question> questionList = questionDao.getQuestionListByCourseId(courseId);
        model.addAttribute("questionList", questionList);
        return "teacher/teacher_test_select";
    }
 //Todo 这里添加考试和选择试题应该在同一个界面
    @RequestMapping("/exam/select")
    public String select(ExamQuestionModel examQuestionModel,HttpSession session,Model model){
        for (ExamQuestion examQuestion : examQuestionModel.getExamQuestionList()) {

            examQuestionDao.save(examQuestion);
        }
        return null;
    }

}
