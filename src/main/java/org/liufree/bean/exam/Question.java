package org.liufree.bean.exam;

import lombok.Data;
import org.liufree.bean.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lwx
 * @date 5/28/17
 * @email liufreeo@gmail.com
 */
@Entity
@Data
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int courseId;               //课程Id;
    int type;                   //题目类型，1为选择题，2为主观题

    String tag;                 //标记，选题的时候可以根据标记来，
                                // 若有两个则加上-，表示为tag1-tag2
    String title;               //题目
    String optiona;             //选项A
    String optionb;
    String optionc;
    String optiond;
    String answer;              //答案
    Date creatTime;             //创建时间
    int unitId;                 //所属单元id


}
