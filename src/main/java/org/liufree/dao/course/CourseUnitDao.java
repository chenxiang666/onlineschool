package org.liufree.dao.course;

import org.liufree.bean.course.CourseUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * @author lwx
 * @date 6/7/17
 * @email liufreeo@gmail.com
 */
public interface CourseUnitDao extends JpaRepository<CourseUnit, Integer> {

    @Query("select c from CourseUnit c where c.courseId=:courseId")
    List<CourseUnit> getCourseUnitListByCourseId(@Param("courseId") int courseId);

    @Query("select c from CourseUnit c where c.courseId=:courseId")
    Page<CourseUnit> getCourseUnitListByCourseId(@Param("courseId") int courseId, Pageable pageable);
}
