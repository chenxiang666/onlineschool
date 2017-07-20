package org.liufree.admincontroller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lwx
 * @date 5/5/17
 * @email liufreeo@gmail.com
 */
@Controller
@RequestMapping("/admin")
public class IndexControllerAdmin {



    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index() {

        return "admin/common/index";
    }
}
