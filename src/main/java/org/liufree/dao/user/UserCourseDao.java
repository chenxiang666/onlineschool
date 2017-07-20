package org.liufree.dao.user;

import org.liufree.bean.user.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lwx
 * @date 6/1/17
 * @email liufreeo@gmail.com
 */
public interface UserCourseDao extends JpaRepository<UserCourse, Integer> {
}
