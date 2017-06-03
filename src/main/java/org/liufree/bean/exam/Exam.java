package org.liufree.bean.exam;

import com.sun.mail.imap.protocol.ID;
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
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int courseId;           //课程id
    Date beginTime;         //开始时间
    Date endTime;           //终止时间
    String title;           //考试标题
    int type;               //考试类型，1为test,2为assignment,2为期中期末考试
    double score;           //总分数


}
