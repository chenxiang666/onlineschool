package org.liufree.dao.user;

import org.liufree.bean.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


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


    @Query("select u from User u where id=:id")
    User findById(@Param("id")int id); //查询相同的名字

    @Query("select u from  User u where role=0")
    List<User> findAllStudent();

    @Query("select u from  User u where role=1")
    List<User> findAllTeacher();

    @Query("select u.id from User u where email=:email and firstName=:firstName")
    int findByEmailAndFirstName(@Param("email")String email, @Param("firstName")String firstName); //
}
