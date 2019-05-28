package work.idler.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.引入SpringSecurity
 * 2.编写SpringSecutity的配置类
 * @EnableWebSecurity
 * public class MySecurityConfig extends WebSecurityConfigurerAdapter {
 * }
 * 3.控制请求的访问权限
 */
@SpringBootApplication
public class SpringBoot05SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot05SecurityApplication.class, args);
    }

}
