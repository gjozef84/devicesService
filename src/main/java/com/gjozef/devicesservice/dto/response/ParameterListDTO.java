package com.gjozef.devicesservice.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ParameterListDTO extends AbstractListDTO<ParameterDTO> {
    public ParameterListDTO(List<ParameterDTO> data) {
        super((long) data.size(), data);
    }
}
