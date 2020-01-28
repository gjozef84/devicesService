package com.gjozef.devicesService.assembler;

import com.gjozef.devicesService.domain.User;
import com.gjozef.devicesService.domain.UserRole;
import com.gjozef.devicesService.dto.response.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDTOAssemblerTest {

    private UserDTOAssembler userDTOAssembler;

    @BeforeEach
    void setUp() {
        userDTOAssembler = new UserDTOAssembler();
    }

    @Test
    void fillInDto() {
        User domain = new User("userName", "pass", "email", "name", "lastName", UserRole.ROLE_USER);
        UserDTO expected = new UserDTO(domain.getId(), domain.getUsername(), domain.getEmail(), domain.getName(), domain.getLastName(), domain.getUserRole());

        UserDTO actual = userDTOAssembler.fromDomain(domain);
        assertEquals(expected, actual);
    }

    @Test
    void createEmptyDto() {
        UserDTO expected = new UserDTO();
        UserDTO actual = userDTOAssembler.createEmptyDto();

        assertEquals(expected, actual);
    }
}