package org.liufree.dao.course;

import org.liufree.bean.course.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lwx
 * @date 5/30/17
 * @email liufreeo@gmail.com
 */
public interface GradeDao extends JpaRepository<Grade,Integer> {
}
