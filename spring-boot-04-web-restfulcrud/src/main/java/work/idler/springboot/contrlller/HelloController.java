package work.idler.springboot.contrlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import work.idler.springboot.exception.UserNotExistException;

import java.util.Arrays;
import java.util.Map;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/8
 * @Description:work.idler.springboot.contrlller
 * @version:1.0
 */

@Controller
public class HelloController {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    //查出一些数据在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //classpath:/templates/success.html
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("<h4>zhangsan</h4>","lisi","wangwu"));
        return "success";
    }
}
