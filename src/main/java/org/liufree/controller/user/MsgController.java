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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dny on 2017/6/9.
 */

@Controller
@RequestMapping(value = "/msg")
public class MsgController {
    @Autowired
    MsgDao msgDao;
    @Autowired
    UserDao userDao;


    //学生的消息
    @RequestMapping(value = "/student")
    public String studentMsg(HttpSession httpSession, Model model) {
        int receiveId = Integer.parseInt(httpSession.getAttribute("userId").toString());
        List<User> senderList = msgDao.getSenderByReceiverId(receiveId);//获取所有给当前用户发过消息的用户
        List<Msg> rootMsgList = msgDao.getRootMsgByReceiverId(receiveId);//获取当前用户所有接收到的根信息
        List<Msg> mineRootMsgList = msgDao.getRootMsgBySenderId(receiveId);//获取当前用户自己发出去的根消息
        List<User> teacherList = msgDao.findTeacherByStuIdAndCourse(receiveId);//该学生的所有授课老师

        model.addAttribute("senderList", senderList);
        model.addAttribute("rootMsgList", rootMsgList);
        model.addAttribute("mineRootMsgList", mineRootMsgList);
        model.addAttribute("teacherList", teacherList);

        return "user/user_message";
    }

    //老师的消息
    @RequestMapping(value = "/teacher")
    public String teacherMsg(HttpSession httpSession, Model model) {
        int receiveId = Integer.parseInt(httpSession.getAttribute("userId").toString());
        List<User> senderList = msgDao.getSenderByReceiverId(receiveId);//获取所有给当前用户发过消息的用户
        List<Msg> rootMsgList = msgDao.getRootMsgByReceiverId(receiveId);//获取当前用户所有接收到的根信息
        List<User> studentList = msgDao.findStudentByTeacherIdAndCourse(receiveId);//获取老师所教课程的所有学生

        model.addAttribute("senderList", senderList);
        model.addAttribute("rootMsgList", rootMsgList);
        model.addAttribute("studentList", studentList);

        return "teacher/teacher_message";
    }

    @RequestMapping(value = "/send")
    public String send(HttpSession httpSession, Msg msg) {
        System.out.println("send");
        System.out.println(DateUtil.getDate());
        int senderId = Integer.parseInt(httpSession.getAttribute("userId").toString());
        msg.setSenderId(senderId);
        msg.setCreateTime(DateUtil.getDate());
        msg.setMsgId(0);//根消息
        msg.setStatus(0);//未读
        msgDao.save(msg);

        return "forward:/msg/student";
    }

    //根据根消息id循环查询其所有子消息
    @RequestMapping(value = "/details/{msgId}")
    public String details(@PathVariable("msgId") int msgId, Model model, HttpSession session) {
        int id = msgId;
        Msg msg = msgDao.getMessageById(id);
        User sender = userDao.findById(msg.getSenderId());
        User receiver = userDao.findById(msg.getReceiverId());

        if (session.getAttribute("userId").equals(sender.getId()))//当前用户是此根消息发送者
            model.addAttribute("finalReceiverId", receiver.getId());//设置最终接收者id
        else //当前用户是此根消息接收者
            model.addAttribute("finalReceiverId", sender.getId());

        model.addAttribute("rootMsg", msg);

        List<Msg> msgList = new ArrayList<>();
        while (msgDao.getMessageByMsgId(id) != null) {
            msg = msgDao.getMessageByMsgId(id);
            msgList.add(msg);
            id = msg.getId();
        }

        model.addAttribute("msgList", msgList);
        model.addAttribute("sender", sender);
        model.addAttribute("receiver", receiver);
        model.addAttribute("replyMsgId", id);

        return "user/message_details";
    }

    //回复消息
    @RequestMapping(value = "/reply/{rootMsgId}")
    //参数依次为：根消息Id-要回复的消息的id，接收者的id，父消息的id，消息内容；页面input框的数据类型和对象属性的数据类型不一致，此处不能用Msg对象
    public String reply(@PathVariable("rootMsgId") int rootMsgId,
                        HttpSession httpSession,
                        @RequestParam(value = "receiverId") String receiverId,
                        @RequestParam(value = "msgId") String msgId,
                        @RequestParam(value = "content") String content) {
        System.out.println("reply");
        System.out.println(DateUtil.getDate());
        System.out.println(rootMsgId);
        System.out.println(msgId);
        System.out.println(receiverId);

        Msg msg = new Msg();
        int senderId = Integer.parseInt(httpSession.getAttribute("userId").toString());
        msg.setContent(content);
        msg.setReceiverId(Integer.parseInt(receiverId));
        msg.setMsgId(Integer.parseInt(msgId));
        msg.setSenderId(senderId);
        msg.setCreateTime(DateUtil.getDate());
        msg.setStatus(0);//未读
        msgDao.save(msg);

        return "forward:/msg/details/" + rootMsgId;
    }
}
