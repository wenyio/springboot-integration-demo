package work.idler.cache.mapper;

import org.apache.ibatis.annotations.*;
import work.idler.cache.bean.Employee;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/14
 * @Description:work.idler.cache.mapper
 * @version:1.0
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public void deleteEmp(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);

    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEmpByLastName(String lastName);
}
