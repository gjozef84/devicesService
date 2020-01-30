package com.gjozef.devicesservice.dto.response;

import com.gjozef.devicesservice.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterDTO implements AbstractDTO {

    private String paramName;
    private String value;
}
