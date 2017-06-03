package org.liufree.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lwx
 * @date 5/5/17
 * @email liufreeo@gmail.com
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        System.out.println("OnlineSchool Success Operation");

        return "common/index";
    }

    @RequestMapping("/register")
    public String register(){
        return "user/register";
    }

    @RequestMapping("/school")
    public String school(){
        return "common/school";
    }

    @RequestMapping("/courses")
    public String courses(){
        return "course/index";
    }

    @RequestMapping("/faq")
    public String faq(){
        return "common/faq";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "common/contact";
    }
}
