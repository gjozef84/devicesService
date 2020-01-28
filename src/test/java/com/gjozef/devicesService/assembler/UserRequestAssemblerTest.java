package com.gjozef.devicesService.assembler;

import com.gjozef.devicesService.domain.User;
import com.gjozef.devicesService.domain.UserRole;
import com.gjozef.devicesService.dto.request.UserRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class UserRequestAssemblerTest {

    private UserRequestAssembler userRequestAssembler;

    @BeforeEach
    void setUp() {
        userRequestAssembler = new UserRequestAssembler();
    }

    @Test
    public void toDomain() {
        UserRequestDTO dto = new UserRequestDTO("userName", "email", null, "name", "lastName", UserRole.ROLE_USER);
        User expected = new User(dto.getUserName(), dto.getPassword(), dto.getEmail(), dto.getName(), dto.getLastName(), dto.getUserRole());

        User actual = userRequestAssembler.toDomain(dto);

        assertEquals(expected, actual);
    }
}