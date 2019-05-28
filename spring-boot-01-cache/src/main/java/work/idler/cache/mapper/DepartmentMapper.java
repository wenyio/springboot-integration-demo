package work.idler.cache.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import work.idler.cache.bean.Department;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/14
 * @Description:work.idler.cache.mapper
 * @version:1.0
 */
@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);
}
