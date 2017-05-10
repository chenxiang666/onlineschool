package org.liufree.bean.user;

import lombok.Data;

import javax.persistence.*;


/**
 * @author lwx
 * @date 5/10/17
 * @email liufreeo@gmail.com
 */
@Entity
@Data
@Table(name = "user_login")
public class UserLogin {

    @Id
    int loginId;

    String loginTime;       //登录时间
    String ip;              //用户ip
    String osName;          //操作系统
    String userAgent;       //用户浏览器

}
