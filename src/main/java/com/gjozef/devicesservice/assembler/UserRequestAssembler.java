package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.User;
import com.gjozef.devicesservice.domain.UserRole;
import com.gjozef.devicesservice.dto.request.UserRequestDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserRequestAssembler implements DTOToDomainAssembler<User, UserRequestDTO> {

    @Override
    public User toDomain(UserRequestDTO dto) {
        Assert.notNull(dto, "DTO cannot be null");

        User domain = new User();
        fillInDomain(dto, domain);

        return domain;
    }

    @Override
    public void fillInDomain(UserRequestDTO dto, User domain) {
        domain.setUsername(dto.getUserName());
        domain.setEmail(dto.getEmail());
        domain.setName(dto.getName());
        domain.setLastName(dto.getLastName());
        domain.setUserRole(UserRole.valueOf(dto.getUserRole().name()));
    }
}
