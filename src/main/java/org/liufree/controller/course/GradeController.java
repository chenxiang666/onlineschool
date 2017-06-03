package org.liufree.controller.course;

import org.liufree.bean.course.Grade;
import org.liufree.dao.course.GradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.soap.Addressing;
import java.util.List;

/**
 * @author lwx
 * @date 5/30/17
 * @email liufreeo@gmail.com
 */
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeDao gradeDao;

    public void index(){

    }

    public String getGradeList(Model model){
        List<Grade> gradeList = gradeDao.findAll();
        model.addAttribute("gradeList", gradeList);
        return null;
    }
}
