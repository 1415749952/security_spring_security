package cn.ccsu.init;

import cn.ccsu.config.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created with IntelliJ IDEA.
 * Description:SpringSecurity 初始化
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 21:26
 */
public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer
{
    public SpringSecurityApplicationInitializer()
    {
        /*
        如果没有使用spring或者springmvc就需要有
        super(WebSecurityConfig.class);
        如果使用spring或者springmvc就需要将
         super(WebSecurityConfig.class);注释掉
         这里使用了就注释掉
         */
        //super(WebSecurityConfig.class);
    }
}
