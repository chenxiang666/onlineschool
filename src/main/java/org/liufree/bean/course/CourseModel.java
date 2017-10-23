package org.liufree.bean.course;

import lombok.Data;
import org.liufree.bean.user.UserCourse;

import java.util.List;

/**
 * @author lwx
 * @date 5/31/17
 * @email liufreeo@gmail.com
 */
@Data
public class CourseModel {

    List<UserCourse> userCourseList;
}
