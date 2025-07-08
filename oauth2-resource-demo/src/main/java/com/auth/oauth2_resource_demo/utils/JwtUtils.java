package com.auth.oauth2_resource_demo.utils;

import com.auth.oauth2_resource_demo.dto.JwtClaimsDto;
import lombok.val;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Map;

public class JwtUtils {

    public static Map<String, Object> getClaims(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = ((JwtAuthenticationToken) authentication).getToken();
        return jwt.getClaims();
    }

    public static JwtClaimsDto getJwtClaimsObject(){
        val claims=getClaims();
        return JwtClaimsDto.builder()
                .id((Integer) claims.get("sub"))
                .username((String) claims.get("username"))
                .roles((String) claims.get("role"))
                .build();
    }
}
