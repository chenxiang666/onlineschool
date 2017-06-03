package org.liufree.bean.user;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lwx
 * @date 5/5/17
 * @email liufreeo@gmail.com
 */
@Data
@Entity
@Table(name = "user")
public class User {                 //老师和学生合在一起，同为user

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String username;          //帐号
    String password;            //密码
    String firstName;           //姓
    String lastName;            //名
    String mobile;              //手机号
    String email;               //email
    String detail;              //自我介绍
    int sex;                    //性别
    String birth;               //生日
    String address;             //住址
    String city;                //城市
    String province;            //省份
    String postalCode;          //邮政编码
    String country;             //国家
    String pic;                 //头像
    int status;            //帐号是否封锁
    String creatTime;           //创建时间
    String updateTime;          //更新时间
    int msgNum;                 //消息数目
    int role;                   //角色，1为学生，2为老师

}
