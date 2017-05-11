package org.liufree.dao.user;

import org.liufree.bean.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


/**
 * @author lwx
 * @date 5/5/17
 * @email liufreeo@gmail.com
 */
@Service
public interface UserDao extends JpaRepository<User, Integer> {

    @Query("select u from User u where username=:username and password=:password")
    User login(@Param("username")String username, @Param("password")String password);

    @Query("select u from User u where username=:username")
    User findByUsername(@Param("username")String username); //查询相同的名字
}
