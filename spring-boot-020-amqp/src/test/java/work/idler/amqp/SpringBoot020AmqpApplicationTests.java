package work.idler.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import work.idler.amqp.bean.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot020AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange(){
//        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
//        System.out.println("创建完成");
//        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));
//        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue",Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqp.haha",null));
        //也可以删除
    }

    /**
     * 1.单播(点对点)direct
     * 2.
     */
    @Test
    public void contextLoads() {
        //message需要自己构造一个;定制消息体内容
        //rabbitTemplate.send(exchange,routekey,message);交换器 路由key 消息

        //object默认当成消息体,只需要传入要发送的对象,自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routekey,Object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化以后发送出去
        //rabbitTemplate.convertAndSend("exchange.direct","idler.news",map);
        rabbitTemplate.convertAndSend("exchange.direct","idler.news",new Book("西游记","吴承恩"));
    }

    //接收数据,如何将数据自动转为json发送出去
    @Test
    public void receive(){
        //rabbitTemplate.receive();同理
        Object o = rabbitTemplate.receiveAndConvert("idler.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播(fanout)
     */
    @Test
    public void sendMsg(){
       // rabbitTemplate.convertAndSend("exchange.fanout","",new Book("三国演义","罗贯中"));
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("红楼梦","曹雪芹"));
    }

}
