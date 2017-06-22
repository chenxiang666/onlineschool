package org.liufree.dao.user;

import org.liufree.bean.msg.Msg;
import org.liufree.bean.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Dny on 2017/6/9.
 */
public interface MsgDao extends JpaRepository<Msg,Integer> {
    @Query("select m from Msg m where receiverId=:receiverId and msgId=0")
    List<Msg> getRootMsgByReceiverId(@Param("receiverId") int receiverId);

    @Query("select m from Msg m where receiverId=:receiverId")
    List<Msg> getMsgByReceiverId(@Param("receiverId") int receiverId);

    @Query("select distinct u from User u,Msg m where m.receiverId=:receiverId and m.senderId=u.id and msgId=0")
    List<User> getSenderByReceiverId(@Param("receiverId") int receiverId);

    @Query("select m from Msg m where msgId=:rootMsgId")
    List<Msg> getByRootMsgId(@Param("rootMsgId") int rootMsgId);

    //通过学生id，找出该学生所选的所有课程，并找出每一个课程的授课老师，distinct去重
    @Query("select distinct u from User u,UserCourse uc,Course c where uc.userId=:id and c.id=uc.courseId and u.id=c.teacherId")
    List<User> findTeacherByStuIdAndCourse(@Param("id")int id);

    //通过老师id，找出该老师所教课程下的所有学生，distinct去重
    @Query("select distinct u from User u,UserCourse uc,Course c where c.teacherId=:id and uc.courseId = c.id and u.id = uc.userId")
    List<User> findStudentByTeacherIdAndCourse(@Param("id")int id);
}
