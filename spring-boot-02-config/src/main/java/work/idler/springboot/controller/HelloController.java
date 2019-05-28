package work.idler.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/7
 * @Description:work.idler.springboot.controller
 * @version:1.0
 */

@RestController
public class HelloController {

    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/sayhello")
    public String sayHello(){
        return "Hello "+name;
    }
}
