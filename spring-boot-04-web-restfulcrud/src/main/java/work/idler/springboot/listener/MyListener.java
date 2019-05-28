package work.idler.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/11
 * @Description:work.idler.springboot.listener
 * @version:1.0
 */
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized...web应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed...当前web项目销毁");
    }
}
