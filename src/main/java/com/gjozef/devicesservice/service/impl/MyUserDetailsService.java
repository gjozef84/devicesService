package com.gjozef.devicesservice.service.impl;

import com.gjozef.devicesservice.domain.User;
import com.gjozef.devicesservice.domain.UserRole;
import com.gjozef.devicesservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName)
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
            user.isActive(), true, true, true, Arrays.asList(authorities));
    }
}
