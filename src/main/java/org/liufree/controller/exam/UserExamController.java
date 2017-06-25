package org.liufree.controller.exam;

import org.liufree.bean.exam.*;
import org.liufree.dao.exam.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lwx
 * @date 6/25/17
 * @email liufreeo@gmail.com
 */
@Controller
@RequestMapping("/user/exam")
public class UserExamController {

    @Autowired
    ExamDao examDao;
    @Autowired
    ExamQuestionDao examQuestionDao;
    @Autowired
    QuestionDao questionDao;
    @Autowired
    ExamResultDao examResultDao;
    @Autowired
    ExamResultQuestionDao examResultQuestionDao;

    @RequestMapping("/doExamPage/{examId}")
    public String doExamPage(@PathVariable("examId") int examId, Model model) {
        Exam exam = examDao.findOne(examId);
        System.out.println(exam.getTitle());
        model.addAttribute("exam", exam);
        /*List<ExamQuestion> examQuestionList = examQuestionDao.getQuestionByExamId(examId);
        model.addAttribute("examQuestionList", examQuestionList);*/
        List<Question> questionList = questionDao.getQuestionListByExamId(examId);
        model.addAttribute("questionList", questionList);
        return "exam/user_doExam";
    }

    @RequestMapping("/doExam/{examId}")
    public String doExam(@PathVariable("examId") int examId, Model model, ExamAnswerModel examAnswerModel, HttpSession session) {
        List<ExamResultQuestionModel> examResultQuestionModelList = new ArrayList<>();
        Double totalScore = 0.0;

        int userId = (Integer) session.getAttribute("userId");
        int courseId = (Integer) session.getAttribute("_courseId");
        for (ExamResultQuestion examResultQuestion : examAnswerModel.getExamResultQuestionList()) {
            ExamResultQuestionModel examResultQuestionModel = new ExamResultQuestionModel();


            examResultQuestion.setExamId(examId);
            examResultQuestion.setUserId(userId);

            String answer = examResultQuestion.getAnswer();
            int questionId = examResultQuestion.getQuestionId();
            Question question = questionDao.findOne(questionId);


            ExamQuestion examQuestion = examQuestionDao.findByExamIdAndQuestionId(examId, questionId);
            if (question.getType() == 1) {
                if (answer.equals(question.getAnswer())) {
                    examResultQuestion.setIsRight(true);
                    totalScore += examQuestion.getItemScore();


                } else
                    examResultQuestion.setIsRight(false);
            }else
            {
                totalScore += examQuestion.getItemScore();
            }
            System.out.println("总分是" + totalScore);
            examResultQuestionDao.save(examResultQuestion);

            examResultQuestionModel.setQuestion(question);  //添加问题
            examResultQuestionModel.setExamResultQuestion(examResultQuestion);  //判断这个问题是否正确
            examResultQuestionModelList.add(examResultQuestionModel);
        }
        Exam exam = examDao.findOne(examId);
        model.addAttribute("exam", exam);
        model.addAttribute("examResultQuestionModelList", examResultQuestionModelList);
        model.addAttribute("totalScore", totalScore);


        ExamResult examResult = new ExamResult();
        examResult.setExamId(examId);
        examResult.setUserId(userId);
        examResult.setCourseId(courseId);
        examResult.setScore(totalScore);
        examResultDao.save(examResult);
        return "exam/user_doExamResult";
    }


}
