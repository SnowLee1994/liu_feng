package com.newcolor.web.config.security;

import com.alibaba.fastjson.JSON;
import com.newcolor.web.controller.utils.JwtUtils;
import com.newcolor.web.controller.utils.ResultUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xuewen.li
 * @date 2021/4/221:09
 * @Description: 登录验证成功处理
 */
@Component
public class JwtLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        WebUserDetails jwtUserDetails = (WebUserDetails) authentication.getPrincipal();
        String json = JSON.toJSONString(jwtUserDetails);
        String jwtToken = JwtUtils.createJwtToken(json, JwtUtils.DEFAULT_TOKEN_TIME_MS);
        response.getWriter().write(JSON.toJSONString(ResultUtil.success(jwtToken)));
    }
}
