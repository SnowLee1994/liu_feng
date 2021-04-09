package com.newcolor.web.config.security;

import com.alibaba.fastjson.JSON;
import com.newcolor.web.controller.utils.JwtUtils;
import com.newcolor.web.controller.utils.ResultUtil;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuewen.li
 * @date 2021/4/221:05
 * @Description: jwt拦截器
 */
public class JwtTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String requestURI = request.getRequestURI();
            //设置放行Urls；不校验Token
            List<String> ignoreUrls = new ArrayList<>();
            ignoreUrls.add("/v2/api-docs");
            ignoreUrls.add("/swagger-resources/configuration/ui");
            ignoreUrls.add("/swagger-resources");
            ignoreUrls.add("/swagger-resources/configuration/security");
            ignoreUrls.add("/swagger-ui.html");
            ignoreUrls.add("/webjars/**");
            for (String pass:ignoreUrls){
                if (requestURI.contains(pass)){
                    filterChain.doFilter(request, response);
                    return;
                }
            }

            String token = request.getHeader("Authorization");
            if (StringUtils.isEmpty(token)) {
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(JSON.toJSONString(ResultUtil.error("未登录！")));
                return;
            }

            Claims claims = JwtUtils.parseJWT(token);
            if (JwtUtils.isTokenExpired(claims)) {
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(JSON.toJSONString(ResultUtil.error("登陆失效，请重新登陆！")));
                return;
            }

            WebUserDetails user = JSON.parseObject(claims.get("userDetails", String.class), WebUserDetails.class);
            JwtLoginToken jwtLoginToken = new JwtLoginToken(user, "", user.getAuthorities());
            jwtLoginToken.setDetails(new WebAuthenticationDetails(request));
            SecurityContextHolder.getContext().setAuthentication(jwtLoginToken);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            throw new BadCredentialsException("登陆凭证失效，请重新登陆");
        }
    }
}
