package org.liufree.bean.msg;

import lombok.Data;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lwx
 * @date 5/10/17
 * @email liufreeo@gmail.com
 */
@Data
@Entity
@Table(name = "msg")
public class Msg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String content;             //内容
    int senderId;                 //发送者Id
    int receiverId;              //收到者Id
    int msgId;                  //父级消息消息Id,便于回复;0表示根消息
    int status;                 //0未读，1已读；默认为0
    Date createTime;           //创建时间
}
