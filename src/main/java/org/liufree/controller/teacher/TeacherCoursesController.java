package org.liufree.controller.teacher;

import org.liufree.bean.course.CourseUnit;
import org.liufree.dao.course.CourseUnitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lwx
 * @date 6/7/17
 * @email liufreeo@gmail.com
 */
@Controller
@RequestMapping("/teacher/courses")
public class TeacherCoursesController {

    @Autowired
    CourseUnitDao courseUnitDao;

    @RequestMapping("/addUnitPage")
    public String addUnitPage() {
        return "teacher/teacher_addUnit";
    }
    @RequestMapping(value = "/addUnit",method = RequestMethod.POST)
    public String addUnit(CourseUnit courseUnit, HttpSession session,Model model) {
       int courseId =(Integer)session.getAttribute("_courseId");
         courseUnit.setCourseId(courseId);
        courseUnitDao.save(courseUnit);
        return "redirect:/teacher/courses/unitList";
    }

    @RequestMapping("/unitList")     //分页查询
    public String unitList(HttpSession session, Model model, @RequestParam(value = "page", defaultValue = "0") Integer page){
        int courseId = (Integer)session.getAttribute("_courseId");
        Pageable pageable = new PageRequest(page, 8, Sort.Direction.ASC, "id");
        Page<CourseUnit> pages = courseUnitDao.getCourseUnitListByCourseId(courseId,pageable);

       // List<CourseUnit> courseUnitList = courseUnitDao.getCourseUnitListByCourseId(courseId);
        model.addAttribute("datas", pages);
        return "teacher/teacher_units";
    }
}
