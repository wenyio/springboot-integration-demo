package work.idler.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/11
 * @Description:work.idler.springboot.filter
 * @version:1.0
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {//初始化

    }

    @Override//过滤
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process..");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override//销毁
    public void destroy() {

    }
}
