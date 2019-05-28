package work.idler.springboot.mapper;

import work.idler.springboot.bean.Employee;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/13
 * @Description:work.idler.springboot.mapper
 * @version:1.0
 */

//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

    public Employee getEmpById(int id);

    public void insetEmp(Employee employee);
}
