package work.idler.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import work.idler.cache.bean.Employee;
import work.idler.cache.mapper.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作字符串

    @Autowired
    RedisTemplate redisTemplate; //k-v 都是对象的

    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    /**
     * Redis常见的五大数据类型
     *      String (字符串) ,List(列表), Set(集合), Hash(散列), ZSet(有序集合)
     *      stringRedisTemplate.opsForValue()  :字符串
     *      stringRedisTemplate.opsForList()   :列表
     *      ...
     *
     *      redisTemplate.opsForValue()    :字符串
     *      redisTemplate.opsForList()     :列表
     *      ...
     *
     */
    @Test
    public void test01(){
        //给redis中保存数据
        //stringRedisTemplate.opsForValue().append("msg","hello");
//        String  msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);

//        stringRedisTemplate.opsForList().leftPush("mylist","1");
//        stringRedisTemplate.opsForList().leftPush("mylist","2");
//        stringRedisTemplate.opsForList().leftPush("mylist","3");
//        stringRedisTemplate.opsForList().leftPush("mylist","4");
    }

    //测试保存对象
    @Test
    public void test02(){
        Employee emp = employeeMapper.getEmpById(1);
        //默认如果保存对象,使用jdk序列化机制,序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",emp);
        //1.将数据以json方式保存
        //   自己将对象转为json
        //   redisTemplate默认的序列化规则,改变默认的序列化规则
        empRedisTemplate.opsForValue().set("emp-01",emp);
    }

    @Test
    public void contextLoads() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }

}

