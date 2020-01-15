package com.xiaotang.springaccount.interceptor;

import com.xiaotang.springaccount.dto.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @data 2020/1/15
 * @time 14:56
 */
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        UserInfo user = (UserInfo)request.getSession().getAttribute("USERINFO");
        logger.info(request.getRequestURI().toString());
        String uri = request.getRequestURI();
        if ( (user == null || user.equals("")) && uri.indexOf("/login") == -1)  {
            response.sendRedirect("/login");
            logger.info("请先登录");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion...");
    }
}