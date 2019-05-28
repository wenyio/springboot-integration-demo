package work.idler.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import work.idler.springboot.bean.Department;
import work.idler.springboot.bean.Employee;
import work.idler.springboot.mapper.DepartmentMapper;
import work.idler.springboot.mapper.EmployeeMapper;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/13
 * @Description:work.idler.springboot.controller
 * @version:1.0
 */

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") int id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") int id){
        return employeeMapper.getEmpById(id);
    }
}
