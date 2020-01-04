package cn.ccsu.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created with IntelliJ IDEA.
 * Description: springSecurity的配置类
 * 作用：
 * 1.定义用户信息服务（查询用户信息）
 * 2.密码编码器
 * 3.安全拦截机制
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 20:56
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    /**
     * 定义用户信息服务（查询用户信息从数据库或者内存）
     *
     * @return
     */
    @Bean
    @Override
    public UserDetailsService userDetailsService()
    {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return manager;
    }

    /**
     * 密码编辑器，比如用md5加密；这里就用字符串比较的方式来进行
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 安全拦截机制（最重要）
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/r/r1").hasAnyAuthority("p1")//访问/r/r1要有p1权限
                .antMatchers("/r/r2").hasAnyAuthority("p2")//访问/r/r2要有p2权限
                .antMatchers("/r/**").authenticated()//所有的/r/**的请求必须认证通过
                .anyRequest().permitAll()//除了的/r/**的请求，其他请求可以访问
                .and()
                .formLogin()//允许表单登录
                .successForwardUrl("/index")//自定义登录成功地址(为一个请求地址)
                .and()
                .logout()//允许注销
                .and().csrf().disable();//允许登出注销

        super.configure(http);
    }
}
