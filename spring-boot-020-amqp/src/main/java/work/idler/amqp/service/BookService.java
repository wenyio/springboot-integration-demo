package work.idler.amqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import work.idler.amqp.bean.Book;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/17
 * @Description:work.idler.amqp.service
 * @version:1.0
 */

@Service
public class BookService {

    @RabbitListener(queues = "idler.news")
    public void receive(Book book){
        System.out.println("收到消息>>"+book);
    }

    @RabbitListener(queues = "idler")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
