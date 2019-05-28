package work.idler.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import work.idler.cache.bean.Employee;
import work.idler.cache.mapper.EmployeeMapper;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/14
 * @Description:work.idler.cache.service
 * @version:1.0
 */


//缓存配置  整个类
@CacheConfig(cacheNames = "emp",cacheManager = "employeeCacheManager")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;


    /**
     * 将方法得运行结果进行缓存,以后再要相同得数据,直接从缓存中获取,不用调用方法
     *
     * CacheManager管理多个Cache组件的, 对缓存的真正CRUD操作在Cache组件中,每一个缓存组件都有自己唯一一个名字
     * @Cacheable几个属性:
     *       cacheNames/value: 指定缓存的名字,将方法的返回值放在那个缓存中,可以指定多个缓存
     *       key: 缓存数据使用的key; 可以用它来指定, 默认使用方法参数的值  1-方法的返回值
     *               编写SpEL: #id:参数id的值 == #a0 == #p0 == #root.args[0]
     *       KeyGenerator: key的生成器, 可以自己指定key的生成器的组件id
     *               key/keyGenerator: 二选一使用
     *       cacheManager: 指定缓存管理器 或者cacheResolver指定获取解析器
     *       condition: 指定符合条件的情况下才缓存
     *               condition = "#id>0" //id>0就缓存
     *               condition = "#a0>1" 第一个参数的值>1的时候才进行缓存
     *       unless: 否定缓存, 当unless指定的条件为true, 方法的返回值就不会被缓存,可以获取到结果进行判断
     *               unless = "#result == null" //除非结果为空 就不缓存
     *               unless = "#a0==2" 如果第一个参数的值为2 不缓存
     *       sync: 是否使用异步
     *               使用异步unless不能使用
     *
     * @param id
     * @return
     */
    @Cacheable(/*cacheNames = {"emp"}*/)
    public Employee getEmp(Integer id){
        System.out.println("->>查询"+id+"号员工<<-");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /**
     * @CachePut: 即调用方法,又更新缓存的数据; 同步更新缓存,前提用一个key!!
     * 修改了数据库的某个数据,同时更新缓存
     * 运行时机:
     *     1.先调用目标方法
     *     2.将目标方法的结果缓存起来
     *
     * 测试步骤:
     *     1.查询一号员工,查到的结果会放在缓存中
     *         key: 1 value: lastName:张三
     *     2.以后查询还是之前的结果
     *     3.更新1号员工,lastName=zhangsan gender=0
     *         将方法的返回值也存进缓存了
     *         key: 传入的employee对象  值:返回的employee
     *     4.查询1号员工
     *         应该是更新后的员工
     *             key = "#employee.id" :使用传入的参数的员工id
     *             key = "#result.id" :使用返回值的id
     *                  cacheable 无法使用 result 运行机制
     *         为什么是没更新的?(1号员工没有在缓存中更新)
     */
    @CachePut(/*value = "emp",*/key = "#employee.id")
    public Employee updateEmp(Employee employee){
        System.out.println("->>updateEmp:"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict: 缓存清除
     * key:指定要清除的数据
     * allEntries = true :清除所有缓存数据
     * beforeInvocation = false :缓存的清除是否在方法之前清除
     *      默认是代表在方法执行之后执行,如果出现异常缓存就不会清除
     */
    @CacheEvict(/*value = "emp",*/key = "#id")
    public void deleteEmp(Integer id){
        System.out.println("->>deleteEmp:"+id);
//        employeeMapper.deleteEmp(id);
    }

    //Caching 定义复杂的缓存规则
    @Caching(
           cacheable = {
                   @Cacheable(/*value = "emp",*/key = "#lastName")
           },
           put = {
                   @CachePut(/*value = "emp",*/key = "#result.id"),
                   @CachePut(/*value = "emp",*/key = "#result.email")
           }
    )
    public Employee getEmpByLastName(String lastName){
        System.out.println("->>ByLastName:"+lastName);
        Employee empByLastName = employeeMapper.getEmpByLastName(lastName);
        return empByLastName;
    }
}
