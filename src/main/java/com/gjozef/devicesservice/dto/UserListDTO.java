package com.gjozef.devicesservice.dto;

import com.gjozef.devicesservice.dto.response.AbstractListDTO;
import com.gjozef.devicesservice.dto.response.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserListDTO extends AbstractListDTO<UserDTO> {
    public UserListDTO(List<UserDTO> data) {
        super((long) data.size(), data);
    }
}