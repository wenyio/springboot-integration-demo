package work.idler.elastiec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种技术来和ES交互
 * 1.Jest(默认不生效)
 *   需要导入jest工具包(io.searchbox.client.JestClient)
 * 2.SpringData ElasticSearch[ES版本有可能不合适]
 *   版本适配说明:https://github.com/spring-projects/spring-data-elasticsearch
 *   如果版本不适配:
 *          1).升级SpringBoot版本
 *          2).获取对应版本的ES
 *     1).Client  clusterNodes, clusterName
 *     2).ElasticsearchTemplate  操作ES
 *     3).编写一个ElasticsearchRepository的子接口来操作ES
 * 两种用法:https://github.com/spring-projects/spring-data-elasticsearch
 *     1.编写一个 ElasticsearchRepository 接口
 *
 */
@SpringBootApplication
public class SpringBoot03ElastiecApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot03ElastiecApplication.class, args);
    }

}
