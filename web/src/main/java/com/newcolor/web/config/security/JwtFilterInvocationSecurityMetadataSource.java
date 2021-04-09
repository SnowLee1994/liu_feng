package com.newcolor.web.config.security;

import com.newcolor.core.dao.ResourceMapper;
import com.newcolor.core.pojo.ResourceRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author xuewen.li
 * @date 2021/4/220:43
 * @Description: 获取有权访问当前资源的角色
 */
@Component
public class JwtFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private ResourceMapper resourceMapper;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<ResourceRoles> resourceInfo = resourceMapper.getAllResourceInfo();
        for (ResourceRoles menu : resourceInfo) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl) && menu.getRoles().size() > 0) {
                String[] roleIds = menu.getRoles().stream().map(r -> r.getId().toString()).toArray(String[]::new);
                return SecurityConfig.createList(roleIds);
            }
        }
        // 如果没有匹配，则默认全部可以访问
        return SecurityConfig.createList();
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
