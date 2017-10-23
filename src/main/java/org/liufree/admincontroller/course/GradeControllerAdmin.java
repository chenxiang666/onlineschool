package org.liufree.admincontroller.course;

import org.liufree.bean.course.Grade;
import org.liufree.dao.course.GradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lwx
 * @date 5/30/17
 * @email liufreeo@gmail.com
 */
@Controller
@RequestMapping("/admin/grade")
public class GradeControllerAdmin {

    @Autowired
    GradeDao gradeDao;

    @RequestMapping("/addGradePage")
    public String addGradePage(){
        return "admin/course/addGrade";
    }

    @RequestMapping(value = "/addGrade",method = RequestMethod.POST)
    public String addGrade(Grade grade){
        gradeDao.save(grade);
        return "success";
    }
}
