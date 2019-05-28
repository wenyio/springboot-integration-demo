package work.idler.springboot.component;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/8
 * @Description:work.idler.springboot.component
 * @version:1.0
 */

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 可以在链接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request){
        String l = request.getParameter("l");
        //System.out.println(l);
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] s = l.split("_");
            locale = new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
