package com.gjozef.devicesservice.dto.response;

import com.gjozef.devicesservice.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceParamsDTO implements AbstractDTO {
    private DeviceDTO deviceDTO;
    private ParameterDTO parameterDTO;
    private String value;
}
