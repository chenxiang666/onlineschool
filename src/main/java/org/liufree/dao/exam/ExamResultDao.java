package org.liufree.dao.exam;

import org.liufree.bean.exam.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author lwx
 * @date 6/26/17
 * @email liufreeo@gmail.com
 */
public interface ExamResultDao extends JpaRepository<ExamResult,Integer> {

    @Query("select q from ExamResult q where q.courseId=:courseId")
    List<ExamResult> findByCourseId(@Param("courseId") int courseId);
}
