package work.idler.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import work.idler.cache.bean.Department;
import work.idler.cache.service.DeptService;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/16
 * @Description:work.idler.cache.controller
 * @version:1.0
 */
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return deptService.getDeptById(id);
    }
}
