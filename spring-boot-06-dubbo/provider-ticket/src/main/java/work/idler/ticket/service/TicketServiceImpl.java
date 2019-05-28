package work.idler.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/18
 * @Description:work.idler.ticket.service.service.impl
 * @version:1.0
 */

@Component
@Service //将服务发布出去 dubbo的
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "<<厉害了,我的国>>";
    }
}
