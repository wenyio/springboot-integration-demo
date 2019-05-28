package work.idler.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import work.idler.springboot.entity.User;
import work.idler.springboot.repository.UserRepository;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/13
 * @Description:work.idler.springboot.controller
 * @version:1.0
 */

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findOne(id);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}
