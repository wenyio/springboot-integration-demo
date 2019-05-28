package work.idler.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "work.idler.springboot.mapper")
@SpringBootApplication
public class SpringBoot06DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06DataMybatisApplication.class, args);
    }

}

