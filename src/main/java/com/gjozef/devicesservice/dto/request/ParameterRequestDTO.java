package com.gjozef.devicesservice.dto.request;

import com.gjozef.devicesservice.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterRequestDTO implements AbstractDTO {

    @NotBlank
    @Size(max = 50)
    private String paramName;

    private String value;
}
