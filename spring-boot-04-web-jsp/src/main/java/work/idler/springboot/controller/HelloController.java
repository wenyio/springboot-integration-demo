package work.idler.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/11
 * @Description:work.idler.springboot.controller
 * @version:1.0
 */

@Controller
public class HelloController {

    @GetMapping("/abc")
    public String hello(Model model){
        model.addAttribute("msg","你好");
        return "success";
    }
}
