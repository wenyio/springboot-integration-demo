package work.idler.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import work.idler.ticket.service.TicketService;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/18
 * @Description:work.idler.user.service
 * @version:1.0
 */
@Service //springboot的
public class UserService {

    @Reference
    TicketService ticketService;
    
    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了>>"+ticket);
    }

}
