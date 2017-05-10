package org.liufree.bean.teacher;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lwx
 * @date 5/10/17
 * @email liufreeo@gmail.com
 */
@Entity
@Data
@Table(name = "teacher")
public class Teacher {

    @Id
    int teacherId;

    String teacherName;             //老师名字
    String password;                //密码
    String career;                  //事业
    String pic;                     //头像
    int status;                     //状态，1正常，0删除，默认为1
    String creatTime;               //创建时间
}
