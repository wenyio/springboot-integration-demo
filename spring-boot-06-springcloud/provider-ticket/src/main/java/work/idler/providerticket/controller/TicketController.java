package work.idler.providerticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import work.idler.providerticket.service.TicketService;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/18
 * @Description:work.idler.providerticket.controller
 * @version:1.0
 */

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    public String getTicket(){
        return ticketService.getTicket();
    }

}
