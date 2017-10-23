package org.liufree.bean.course;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lwx
 * @date 5/28/17
 * @email liufreeo@gmail.com
 */
@Entity
@Data
@Table(name = "course_file")
public class CourseFile {       //每堂课的文件

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int unitId;           //course_unit表里面的unitId
    String title;           //文件标题
    String url;             //文件路径
    Date time;              //上传时间

    int sort;               //排序


}
