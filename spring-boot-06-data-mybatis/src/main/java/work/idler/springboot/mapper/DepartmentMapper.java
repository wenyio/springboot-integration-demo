package work.idler.springboot.mapper;

import org.apache.ibatis.annotations.*;
import work.idler.springboot.bean.Department;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/13
 * @Description:work.idler.springboot.mapper
 * @version:1.0
 */

//这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(int id);

    @Delete("delete from department where id=#{id}")
    public int deleteDept(int id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
