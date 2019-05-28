package work.idler.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/18
 * @Description:work.idler.actuator.health
 * @version:1.0
 */
@Component
public class MyAppHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        //自定义的检擦方法
        //return Health.up().build(); //代表健康
        return Health.down().withDetail("msg","服务异常").build();
    }
}
