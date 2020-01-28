package com.gjozef.devicesService.dto.request;

import com.gjozef.devicesService.domain.UserRole;
import com.gjozef.devicesService.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class UserRequestDTO implements AbstractDTO {

    @NotBlank
    @Size(min = 5, max = 30)
    private String userName;

    @NotBlank
    @Email
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(min = 5)
    private String password;

    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String lastName;

    @NotNull
    private UserRole userRole;
}
