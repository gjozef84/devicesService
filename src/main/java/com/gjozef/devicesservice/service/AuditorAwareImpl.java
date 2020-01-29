package com.gjozef.devicesservice.service;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        String user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        return Optional.ofNullable(user);
    }
}
