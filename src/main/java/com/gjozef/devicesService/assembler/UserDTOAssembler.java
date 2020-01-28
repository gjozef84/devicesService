package com.gjozef.devicesService.assembler;

import com.gjozef.devicesService.domain.User;
import com.gjozef.devicesService.dto.response.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDTOAssembler extends AbstractDomainToDTOAssembler<User, UserDTO> {

    @Override
    protected void fillInDto(User domain, UserDTO dto) {
        dto.setId(domain.getId());
        dto.setUserName(domain.getUsername());
        dto.setName(domain.getName());
        dto.setLastName(domain.getLastName());
        dto.setEmail(domain.getEmail());
        dto.setUserRole(domain.getUserRole());
    }

    @Override
    protected UserDTO createEmptyDto() {
        return new UserDTO();
    }
}
