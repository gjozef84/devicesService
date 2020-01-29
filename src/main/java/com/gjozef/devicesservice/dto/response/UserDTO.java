package com.gjozef.devicesservice.dto.response;

import com.gjozef.devicesservice.domain.UserRole;
import com.gjozef.devicesservice.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements AbstractDTO {
    private Long id;
    private String userName;
    private String email;
    private String name;
    private String lastName;
    private UserRole userRole;
}
