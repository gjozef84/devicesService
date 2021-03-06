package com.gjozef.devicesservice.dto.request;

import com.gjozef.devicesservice.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterRequestDTO implements AbstractDTO {
    @NotBlank
    private String name;
}
