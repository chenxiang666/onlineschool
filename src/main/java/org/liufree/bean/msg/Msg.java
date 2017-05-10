package org.liufree.bean.msg;

import lombok.Data;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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
@Table(name = "msg")
public class Msg {

    @Id
    int msgId;

    String content;             //内容
    int sentId;                 //发送者Id
    int receiveId;              //收到者Id
    int status;                 //0未读，1已读；默认为0
    String creatTime;           //创建时间
}
