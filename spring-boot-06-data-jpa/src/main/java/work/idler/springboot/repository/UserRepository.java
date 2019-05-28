package work.idler.springboot.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import work.idler.springboot.entity.User;

import java.util.List;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/13
 * @Description:work.idler.springboot.repository
 * @version:1.0
 */

//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User, Integer> {
}
