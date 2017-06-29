package org.liufree.dao.course;

import org.liufree.bean.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author lwx
 * @date 5/31/17
 * @email liufreeo@gmail.com
 */
public interface CourseDao extends JpaRepository<Course,Integer> {
    @Query("select c from Course c where gradeId=:gradeId")
    List<Course> getCoursesByGradeId(@Param("gradeId") int gradeId);

    @Query("select c from Course c,UserCourse u where u.userId=:userId and c.id=u.courseId")
    List<Course> getCoursesByUserId(@Param("userId") int userId);

    @Query("select  c from  Course c where id=:courseId")
    Course getCourseById(@Param("courseId") int courseId);

    List<Course> findAll();

    @Query("select c from Course c where c.teacherId=:teacherId")
    List<Course> getCoursesByTeacherId(@Param("teacherId") int teacherId);
}
