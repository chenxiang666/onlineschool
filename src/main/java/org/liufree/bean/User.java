package org.liufree.bean;

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

    String username;
    String password;

}
