package org.liufree.controller.exam;

import org.liufree.bean.exam.Question;
import org.liufree.dao.exam.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lwx
 * @date 6/6/17
 * @email liufreeo@gmail.com
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionDao questionDao;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Question question,Model model){

        questionDao.save(question);
        return null;                //Todo 加一个界面，列出所有的题目的界面
    }
}
