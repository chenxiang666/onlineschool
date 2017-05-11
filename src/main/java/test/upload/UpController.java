package test.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.PropertyResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author lwx
 * @date 5/10/17
 * @email liufreeo@gmail.com
 */
@Controller
@RequestMapping("/upload")
public class UpController {


    @RequestMapping("/toUp")
    public String toUp(){
        return "test/upload/upload";
    }
    @RequestMapping("/up")
    public String up(@RequestParam(value = "file",
            required = false) MultipartFile file,
                     HttpServletRequest request, ModelMap model) {

        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);

        return "test/upload/result";
    }
}
