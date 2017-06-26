package org.liufree.controller.teacher;

import org.liufree.bean.course.Course;
import org.liufree.bean.course.CourseUnit;
import org.liufree.bean.exam.Question;
import org.liufree.dao.course.CourseDao;
import org.liufree.dao.course.CourseUnitDao;
import org.liufree.dao.exam.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lwx
 * @date 6/8/17
 * @email liufreeo@gmail.com
 */
@Controller
@RequestMapping("/teacher/questions")
public class TeacherQuestionsController {

    @Autowired
    QuestionDao questionDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    CourseUnitDao courseUnitDao;

    //查看当前课程所有题目
    @RequestMapping("/questionList")
    public String questionsList(Model model, HttpSession session, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        int courseId = (Integer) session.getAttribute("_courseId");
        List<CourseUnit> courseUnitList = courseUnitDao.getCourseUnitListByCourseId(courseId);//这门课的所有单元
        Pageable pageable = new PageRequest(page, 8, Sort.Direction.ASC, "id");
        Page<Question> datas = questionDao.getQuestionListByCourseId(courseId, pageable);//这门课所有已有题目

        model.addAttribute("courseUnitList",courseUnitList);
        model.addAttribute("datas", datas);
        return "teacher/questions";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Question question, HttpSession session) {
        //Todo 这里有一个bug，用session存储的值过十几分钟消失，然后会报错，之后在处理

        int courseId = (Integer) session.getAttribute("_courseId");
        question.setCourseId(courseId);
        if (question.getOptiona() != null)
            question.setType(1);    //选择题
        else
            question.setType(2);      //主观题
        questionDao.save(question);
        return "redirect:/teacher/questions/questionList";
    }

    //跳转到添加题目页面
    @RequestMapping("/addPage")
    public String addPage(Model model, HttpSession session) {
        int courseId = (Integer) session.getAttribute("_courseId");
        List<CourseUnit> courseUnitList = courseUnitDao.getCourseUnitListByCourseId(courseId);//这门课的所有单元

        model.addAttribute("courseUnitList",courseUnitList);
        return "teacher/teacher_addQuestion";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        questionDao.delete(id);
        return "redirect:/teacher/questions/questionList";
    }
}
