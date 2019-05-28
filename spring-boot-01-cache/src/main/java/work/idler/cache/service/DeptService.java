package work.idler.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;
import work.idler.cache.bean.Department;
import work.idler.cache.mapper.DepartmentMapper;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/16
 * @Description:work.idler.cache.service
 * @version:1.0
 */
@CacheConfig(cacheNames = "dept",cacheManager = "deptCacheManager")
@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;

    /**
     *  缓存的数据能存入redis
     *  第二次从缓存中查询就不能反序列化回来
     *  存的是dept的json数据; CacheManager默认使用RedisTemplate<Object, Employee>操作redis
     *
     * @param id
     * @return
     */
//    @Cacheable(/*value = "dept"*//*,cacheManager = "deptCacheManager"*/)
//    public Department getDeptById(Integer id){
//        System.out.println("查询部门"+id);
//        Department dept = departmentMapper.getDeptById(id);
//        return dept;
//    }

    //使用缓存管理器得到缓存, 进行api调用  编码方式
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department dept = departmentMapper.getDeptById(id);

        //获取某个缓存
        Cache cache = deptCacheManager.getCache("dept");
        cache.put("dept:1",dept);

        return dept;
    }
}
