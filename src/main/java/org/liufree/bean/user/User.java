package org.liufree.bean.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lwx
 * @date 5/5/17
 * @email liufreeo@gmail.com
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    int userId;

    String username;          //帐号
    String password;            //密码
    String firstName;           //姓
    String lastName;            //名
    String mobile;              //手机号
    String email;               //email
    int sex;                    //性别
    String birth;               //生日
    String address;             //住址
    String city;                //城市
    String province;            //省份
    String postalCode;          //邮政编码
    String country;             //国家
    String pic;                 //头像
    int isAvailable;            //帐号是否封锁
    String creatTime;           //创建时间
    String updateTime;          //更新时间
    int msgNum;                 //消息数目


}
