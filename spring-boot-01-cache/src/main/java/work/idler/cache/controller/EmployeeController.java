package work.idler.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import work.idler.cache.bean.Employee;
import work.idler.cache.service.EmployeeService;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/14
 * @Description:work.idler.cache.controller
 * @version:1.0
 */

@RestController  //返回json 数据
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmp(id);
        return emp;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee){
        Employee updateEmp = employeeService.updateEmp(employee);
        return updateEmp;
    }

    @GetMapping("/delemp")
    public String deleteEmp(Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
