package work.idler.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/6
 * @Description:work.idler.springboot.controller
 * @version:1.0
 */

//这个类的所有方法返回的数据直接写给浏览器.(如果是对象转为json数据)
/*@ResponseBody
@Controller*/
@RestController  //==上面的那两个
public class HelloController {

    //@ResponseBody
    @RequestMapping("/helloq")
    public String hello(){
        return "hello world quick!";
    }

    // RESTAPI的方式
}
