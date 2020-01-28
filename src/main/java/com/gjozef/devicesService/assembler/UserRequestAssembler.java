package com.gjozef.devicesService.assembler;

import com.gjozef.devicesService.domain.User;
import com.gjozef.devicesService.domain.UserRole;
import com.gjozef.devicesService.dto.request.UserRequestDTO;
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
