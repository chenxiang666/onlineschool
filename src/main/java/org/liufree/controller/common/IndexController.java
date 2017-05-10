package org.liufree.controller.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lwx
 * @date 5/5/17
 * @email liufreeo@gmail.com
 */
@Controller
public class IndexController {

    private static Log logger = LogFactory.getLog(IndexController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {

        logger.info("11111111通过class对象来获取logger对象.");
        logger.error("111111111.....error");
        System.out.println("刘文想");
        return "go";
    }
}
