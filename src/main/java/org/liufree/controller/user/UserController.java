package org.liufree.controller.user;


import org.liufree.bean.user.User;
import org.liufree.common.Encode;
import org.liufree.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lwx
 * @date 5/5/17
 * @email liufreeo@gmail.com
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String index(@PathVariable("id") int id, ModelMap modelMap) {
        User user = userDao.findOne(id);
        modelMap.addAttribute("user", user);
        return "index";
    }


    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "user/login";
    }

    @RequestMapping(value = "/toRegister")
    public String toRegister() {
        return "user/register";
    }

    @RequestMapping(value = "/toUpdate")
    public String toUpdate() {
        return "user/update";
    }

    @RequestMapping(value = "/toLogut")
    public String toLogut() {
        return "user/logut";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession httpSession) {
        String username = user.getUsername();
        String password = user.getPassword();
        user.setPassword(Encode.getMd5(password));
        User user1;
        if ((user1 = userDao.login(username, Encode.getMd5(password))) != null) {
            httpSession.setAttribute("userId", user1.getUserId());
            model.addAttribute("user", user1);
            return "user/detail";
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user, Model model) {
        String password = user.getPassword();
        user.setPassword(Encode.getMd5(password));
        userDao.save(user);     //存进数据库
        return "common/index";
    }

    @RequestMapping(value = "/logut")
    public String logut(HttpSession httpSession) {
        httpSession.getAttribute("username");
        return "index";
    }

    @RequestMapping(value = "/getUserList")
    public String getUserList(Model model) {

        List<User> userList;
        userList = userDao.findAll();
        model.addAttribute("userList", userList);
        return "user/getAllUser";
    }

}
