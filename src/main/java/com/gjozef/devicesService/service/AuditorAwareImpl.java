package com.gjozef.devicesService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<String> getCurrentAuditor() {

        //String user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        String user = "System";

        return Optional.ofNullable(user);
    }
}
