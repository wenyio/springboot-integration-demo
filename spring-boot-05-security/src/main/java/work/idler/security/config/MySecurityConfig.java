package work.idler.security.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/18
 * @Description:work.idler.security.config
 * @version:1.0
 */

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登陆功能,如果没有全限就会来到登陆页面
        //http.formLogin();
        //1./login来到登陆页
        //2.重定向到/login?error表示登陆失败
        //3....
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin"); //自定义登陆页面
        //4.默认post形式的/login代表处理登陆
        //5.一旦定制loginPage; 那么 loginPag的post请求就是登陆

        //开启自动配置注销功能
        //http.logout();
        //1.访问 /logout 表示用户注销,清空session
        //注销成功会返回到 login 页面
        http.logout().logoutSuccessUrl("/");//注销成功后来到首页

        //开启记住我功能
        //http.rememberMe();
        //登陆成功以后,有cookie发给浏览器保存 以后访问页面带上这个cookie
        //注销后删除cookie
        http.rememberMe().rememberMeParameter("remember"); //自定义remember

    }

    //定义认证规则

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123456").roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP2","VIP3")
                .and()
                .withUser("wangwu").password("123456").roles("VIP1","VIP3");
    }
}
