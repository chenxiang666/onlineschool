package org.liufree.bean.grade;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lwx
 * @date 5/10/17
 * @email liufreeo@gmail.com
 */
@Data
@Entity
@Table(name = "grade")
public class Grade {            //年级

    @Id
    int gradeId;

    String gradeName;           //年级名字
    String detail;              //描述
    String creatTime;           //创建时间
    String updateTime;          //更新时间
    int status;                 //状态，1为正常，0为删除
}
