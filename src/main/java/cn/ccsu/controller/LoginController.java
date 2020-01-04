package cn.ccsu.controller;


import cn.ccsu.model.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 16:42
 */
@RestController
public class LoginController
{
    /**
     * 这个请求在Security的配置类（WebSecurityConfig.java）中配置的
     * 是登陆完成后进入的请求
     *
     * @return
     */
    @RequestMapping(value = "/index", produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess()
    {
        return "登录成功";
    }

    @RequestMapping(value = "/r/r1", produces = {"text/plain;charset=UTF-8"})
    public String r1(HttpSession session)
    {

        return "访问资源r1";
    }

    @RequestMapping(value = "/r/r2", produces = {"text/plain;charset=UTF-8"})
    public String r2(HttpSession session)
    {

        return "访问资源r2";
    }
}
