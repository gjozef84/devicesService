package com.gjozef.devicesservice.dto.response;

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
