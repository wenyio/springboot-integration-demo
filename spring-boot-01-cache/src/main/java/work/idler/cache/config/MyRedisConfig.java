package work.idler.cache.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import work.idler.cache.bean.Department;
import work.idler.cache.bean.Employee;

import java.net.UnknownHostException;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/16
 * @Description:work.idler.cache.config
 * @version:1.0
 */

@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory
    ) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Employee> redisSerializer;
        redisSerializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);

        template.setDefaultSerializer(redisSerializer);
        return  template;
    }

    @Bean
    public RedisTemplate<Object, Department> deptRedisTemplate(
            RedisConnectionFactory redisConnectionFactory
    ) throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Department> redisSerializer;
        redisSerializer = new Jackson2JsonRedisSerializer<Department>(Department.class);

        template.setDefaultSerializer(redisSerializer);
        return  template;
    }

    //CaheManagerCustomizers可以来定制缓存的一些规则
    @Primary //标注默认的缓存管理器
    @Bean
    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, Employee> empRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
        //key多了一个前缀

        //使用前缀,默认会将CacheName作为前缀
        cacheManager.setUsePrefix(true);

        return cacheManager;
    }

    @Bean
    public RedisCacheManager deptCacheManager(RedisTemplate<Object, Department> deptRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(deptRedisTemplate);
        //key多了一个前缀

        //使用前缀,默认会将CacheName作为前缀
        cacheManager.setUsePrefix(true);

        return cacheManager;
    }
}
