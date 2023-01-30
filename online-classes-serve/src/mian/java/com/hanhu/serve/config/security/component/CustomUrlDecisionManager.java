package com.hanhu.serve.config.security.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 权限控制
 * 判断用户角色
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {

    //只需第一个方法
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        for (ConfigAttribute configAttribute : configAttributes){
            //当前url所需要的角色
            String needRole = configAttribute.getAttribute();
            //判断角色是否登录即可访问的角色，此角色在CustomFilter中设置
            if("ROLE_LOGIN".equalsIgnoreCase(needRole)){

                if(authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登录请登录。-CustomUrlDecisionManger");
                }else{
                    return;
                }
            }
            //判断用户角色是否为url所需角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for(GrantedAuthority grantedAuthority : authorities){
                if(grantedAuthority.getAuthority().equals(needRole)){
                    return;
                }
            }
        }

        //
        throw new AccessDeniedException("权限不足，请联系管理员。-CustomUrlDecisionManger");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
