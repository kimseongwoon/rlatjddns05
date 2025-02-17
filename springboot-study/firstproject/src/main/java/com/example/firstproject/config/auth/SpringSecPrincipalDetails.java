package com.example.firstproject.config.auth;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.example.firstproject.models.entity.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Getter
public class SpringSecPrincipalDetails implements UserDetails, OAuth2User {
    private User user;  // 해당 프로그램에서 정의한 User Entity
    private Map<String, Object> userAttrs;

    // 일반 로그인
    public SpringSecPrincipalDetails(User user) {
        this.user = user;
    }

    // 소셜 로그인
    public SpringSecPrincipalDetails(User user, Map<String, Object> userAttrs) {
        this.user = user;
        this.userAttrs = userAttrs;
    }

    // OAuth2User
    @Override
    public Map<String, Object> getAttributes() {
        return userAttrs;
    }

    // OAuth2User
    @Override
    public String getName() {
        return "";
    }

    // UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });

        // ex) admin or manager or user
        // ex) admin or user
        // ex) manager or user
        return collection;
    }

    // UserDetails
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
