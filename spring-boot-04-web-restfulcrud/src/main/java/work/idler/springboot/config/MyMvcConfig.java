package work.idler.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import work.idler.springboot.component.LoginHandlerinterceptor;
import work.idler.springboot.component.MyLocaleResolver;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/8
 * @Description:work.idler.springboot.config
 * @version:1.0
 */
//使用WebMvcConfigurerAdapter可以来扩展SpringMvc的功能
//@EnableWebMvc  不要接管SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送 /idler 请求到 success
        registry.addViewController("idler").setViewName("success");
    }

    //所有的WebMvcConfigureAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源: css js
                //SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerinterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
