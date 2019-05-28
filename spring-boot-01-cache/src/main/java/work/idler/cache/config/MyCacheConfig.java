package work.idler.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/15
 * @Description:work.idler.cache.config
 * @version:1.0
 */

@Configuration
public class MyCacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+"["+ Arrays.asList(objects).toString()+"]";
            }
        };
    }
}
