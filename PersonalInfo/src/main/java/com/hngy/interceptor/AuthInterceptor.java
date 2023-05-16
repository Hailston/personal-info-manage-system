package com.hngy.interceptor;

import com.hngy.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 6-126
 * @date 2023/4/28 14:56
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        User user = (User) session.getAttribute("user");
        if (user == null){
            // 用户未登录， 如果访问的网址是 /login 或者 /register 放行
            if ("/login".equals(uri) || "/register".equals(uri) ||
                    "/handleRegister".equals(uri) || "/handleLogin".equals(uri)){
                return true;
            }
            // 用户未登录, 重定向到登录页面
            response.sendRedirect("/login");
            return false;
        }
        if ("/login".equals(uri) || "/register".equals(uri) ||
                "/handleRegister".equals(uri) || "/handleLogin".equals(uri)){
            // 如果用户登录了，则不能再访问 /login 和 /register 页面
            response.sendRedirect("/index");
            return false;
        }
        // 如果用户登录了，并且访问的页面不是 /login 和 /register 页面，放行
        return true;
    }
}
