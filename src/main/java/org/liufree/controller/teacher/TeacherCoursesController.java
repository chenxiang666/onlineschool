package org.liufree.controller.teacher;

import org.liufree.bean.course.CourseFile;
import org.liufree.bean.course.CourseUnit;
import org.liufree.dao.course.CourseFileDao;
import org.liufree.dao.course.CourseUnitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
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
    @Autowired
    CourseFileDao courseFileDao;

    @RequestMapping("/addUnitPage")
    public String addUnitPage() {
        return "teacher/teacher_addUnit";
    }

    @RequestMapping(value = "/addUnit", method = RequestMethod.POST)
    public String addUnit(CourseUnit courseUnit, HttpSession session, Model model) {
        int courseId = (Integer) session.getAttribute("_courseId");
        courseUnit.setCourseId(courseId);
        courseUnitDao.save(courseUnit);
        return "redirect:/teacher/courses/unitList";
    }

    @RequestMapping("/unitList")     //分页查询
    public String unitList(HttpSession session, Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        int courseId = (Integer) session.getAttribute("_courseId");
        Pageable pageable = new PageRequest(page, 8, Sort.Direction.ASC, "id");
        Page<CourseUnit> pages = courseUnitDao.getCourseUnitListByCourseId(courseId, pageable);

        // List<CourseUnit> courseUnitList = courseUnitDao.getCourseUnitListByCourseId(courseId);
        model.addAttribute("datas", pages);
        return "teacher/teacher_units";
    }

    @RequestMapping("/fileList")
    public String fileList(HttpSession session, Model model) {
        int courseId = (Integer) session.getAttribute("_courseId");

        List<CourseFile> courseFileList = courseFileDao.findAll();
        List<CourseUnit> courseUnitList = courseUnitDao.getCourseUnitListByCourseId(courseId);
        model.addAttribute("courseUnitList", courseUnitList);
        model.addAttribute("courseFileList", courseFileList);
        return "file/teacher_files";
    }

    @RequestMapping("/addFilePage")
    public String addFilePage(HttpSession session, Model model) {
        int courseId = (Integer) session.getAttribute("_courseId");
        List<CourseUnit> courseUnitList = courseUnitDao.getCourseUnitListByCourseId(courseId);
        model.addAttribute("courseUnitList", courseUnitList);
        return "file/add_file";
    }

    @RequestMapping(value = "/addFile", method = RequestMethod.POST)
    public String addFile(@RequestParam(value = "courseFile.url", required = false) CommonsMultipartFile file, HttpServletRequest request, CourseFile courseFile, Model model) {
        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));// 取文件格式后缀名
        String filename = System.currentTimeMillis() + type;// 取当前时间戳作为文件名
        System.out.println(path);
        File targetFile = new File(path, filename);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String url = request.getContextPath() + "/upload/" + filename;
        courseFile.setUrl(url);
        courseFileDao.save(courseFile);
        return "redirect:/teacher/courses/fileList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        courseFileDao.delete(id);
        return "redirect:/teacher/courses/fileList";
    }
}

