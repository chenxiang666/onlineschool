package org.liufree.controller;


import org.liufree.bean.User;
import org.liufree.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lwx
 * @date 5/5/17
 * @email liufreeo@gmail.com
 */
@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public String index(@PathVariable("id") int id, ModelMap modelMap){
        User user = userDao.findOne(id);
        modelMap.addAttribute("user",user);
        return "index";
    }
}
