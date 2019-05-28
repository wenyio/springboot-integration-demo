package work.idler.springboot02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/7
 * @Description:work.idler.springboot02.controller
 * @version:1.0
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
