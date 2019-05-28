package work.idler.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义健康状态指示器
 * 1.编写一个只是器 实现HealthIndicator接口
 * 2.指示器名字 xxxHealthIndicator
 * 3.加入容器
 */
@SpringBootApplication
public class SpringBoot08ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot08ActuatorApplication.class, args);
    }

}
