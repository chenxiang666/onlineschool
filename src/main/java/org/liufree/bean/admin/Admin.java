package org.liufree.bean.admin;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lwx
 * @date 5/10/17
 * @email liufreeo@gmail.com
 */
@Entity
@Data
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String adminName;
    String password;
}
