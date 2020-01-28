package com.gjozef.devicesService.service.impl;

import com.gjozef.devicesService.domain.User;
import com.gjozef.devicesService.domain.UserRole;
import com.gjozef.devicesService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUsername(userName)
            .orElseThrow(() -> new UsernameNotFoundException("User " + userName + "not found."));
        GrantedAuthority authorities = getUserAuthority(user.getUserRole());
        UserDetails userDetails = buildUserForAuthentication(user, authorities);
        return userDetails;
    }

    private GrantedAuthority getUserAuthority(UserRole userRole) {
        return new SimpleGrantedAuthority(userRole.name());
    }

    private UserDetails buildUserForAuthentication(User user, GrantedAuthority authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
            user.isActive(), true, true, true, Collections.singleton(authorities));
    }
}
