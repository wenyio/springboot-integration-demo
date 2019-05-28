package work.idler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/6
 * @Description:work.idler
 * @version:1.0
 */

/**
 * @SpringBootApplication 来标注一个主程序类,说明这是一个Spring Boot应用
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {

        // Spring应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
