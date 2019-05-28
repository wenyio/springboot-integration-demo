package work.idler.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/9
 * @Description:work.idler.springboot.component
 * @version:1.0
 */

/**
 * 登陆检查
 */
public class LoginHandlerinterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object user = httpServletRequest.getSession().getAttribute("loginUser");
        if(user == null){
            //未登录,返回登陆页面
            httpServletRequest.setAttribute("msg","没有权限请先登陆");
            httpServletRequest.getRequestDispatcher("/index.html").forward(httpServletRequest,httpServletResponse);
            return false;
        }else{
            //已登陆,放行请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
