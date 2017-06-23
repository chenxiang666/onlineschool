package org.liufree.controller.user;

import org.liufree.bean.msg.Msg;
import org.liufree.bean.user.User;
import org.liufree.common.DateUtil;
import org.liufree.dao.user.MsgDao;
import org.liufree.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Dny on 2017/6/9.
 */

@Controller
@RequestMapping(value = "/msg")
public class MsgController {
    @Autowired
    MsgDao msgDao;

    //学生的消息
    @RequestMapping(value = "/student")
    public String studentMsg(HttpSession httpSession, Model model) {
        int receiveId = Integer.parseInt(httpSession.getAttribute("userId").toString());
        List<User> senderList = msgDao.getSenderByReceiverId(receiveId);//获取所有给当前用户发过消息的用户
        List<Msg> rootMsgList = msgDao.getRootMsgByReceiverId(receiveId);//获取当前用户所有接收到的根信息
        List<User> teacherList = msgDao.findTeacherByStuIdAndCourse(receiveId);//该学生的所有授课老师

        model.addAttribute("senderList",senderList);
        model.addAttribute("rootMsgList",rootMsgList);
        model.addAttribute("teacherList",teacherList);

        return "user/user_message";
    }

    //老师的消息
    @RequestMapping(value = "/teacher")
    public String teacherMsg(HttpSession httpSession, Model model) {
        int receiveId = Integer.parseInt(httpSession.getAttribute("userId").toString());
        List<User> senderList = msgDao.getSenderByReceiverId(receiveId);//获取所有给当前用户发过消息的用户
        List<Msg> rootMsgList = msgDao.getRootMsgByReceiverId(receiveId);//获取当前用户所有接收到的根信息
        List<User> studentList = msgDao.findStudentByTeacherIdAndCourse(receiveId);//获取老师所教课程的所有学生

        model.addAttribute("senderList",senderList);
        model.addAttribute("rootMsgList",rootMsgList);
        model.addAttribute("studentList",studentList);

        return "teacher/teacher_message";
    }

    @RequestMapping(value = "/send")
    public String send(HttpSession httpSession,Msg msg) {
        System.out.println("send");
        System.out.println(DateUtil.getDate());
        int senterId = Integer.parseInt(httpSession.getAttribute("userId").toString());
        msg.setSenderId(senterId);
        msg.setCreateTime(DateUtil.getDate());
        msg.setMsgId(0);//根消息
        msg.setStatus(0);//未读
        msgDao.save(msg);

        return "forward:/msg/student";
    }

//    //根据根消息id递归查询其所有子消息
//    @RequestMapping(value = "/details/${msgId}")
//    public String details(@PathVariable("msgId")int msgId) {
//
//        return "forward:/msg/";
//    }
}
