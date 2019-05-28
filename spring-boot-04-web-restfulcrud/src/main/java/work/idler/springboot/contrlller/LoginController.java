package work.idler.springboot.contrlller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/9
 * @Description:work.idler.springboot.contrlller
 * @version:1.0
 */

@Controller
public class LoginController {

//    @DeleteMapping
//    @PutMapping
//    @GetMapping
//    @RequestMapping(Value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){//username不为空
            //登陆成功,防止重复提交,可以重定向到主页
            session.setAttribute("loginUser",username);
            //return "success";
            return "redirect:/main.html";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
