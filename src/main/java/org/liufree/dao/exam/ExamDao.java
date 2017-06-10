package org.liufree.dao.exam;

import org.liufree.bean.course.Course;
import org.liufree.bean.exam.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author lwx
 * @date 6/9/17
 * @email liufreeo@gmail.com
 */
public interface ExamDao extends JpaRepository<Exam, Integer> {


    @Query("select e from Exam e where e.courseId=:courseId ")
    List<Exam> getExamsByCourseId(@Param("courseId") int courseId);

}
