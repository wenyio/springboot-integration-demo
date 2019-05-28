package work.idler.springboot.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import work.idler.springboot.filter.MyFilter;
import work.idler.springboot.listener.MyListener;
import work.idler.springboot.servlet.MyServlet;

import java.util.Arrays;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/11
 * @Description:work.idler.springboot.config
 * @version:1.0
 */
@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return  filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }

    //配置嵌入式的Servlet容器
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {

            //定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
                configurableEmbeddedServletContainer.setPort(8083);
            }
        };
    }
}
