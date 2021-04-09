package com.newcolor.web.config.security;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xuewen.li
 * @date 2021/4/322:47
 * @Description: 跨域过滤器
 */
@Component
public class JwtCorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        //这里通过判断请求的方法，判断此次是否是预检请求，
        if ("OPTIONS".equals(httpRequest.getMethod())){
            // 如果是，立即返回一个204状态吗，标示，允许跨域；预检后，正式请求，这个方法参数就是我们设置的post了
            httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
            httpResponse.setHeader("Access-Control-Allow-Headers", "*");
            httpResponse.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
            httpResponse.addHeader("Access-Control-Max-Age", "1");  // 预检有效保持时间
        }
        chain.doFilter(request, response);
    }

}
