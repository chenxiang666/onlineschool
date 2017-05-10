package org.liufree.dao.user;

import org.liufree.bean.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * @author lwx
 * @date 5/5/17
 * @email liufreeo@gmail.com
 */
@Service
public interface UserDao  extends JpaRepository<User, Integer> {
}
