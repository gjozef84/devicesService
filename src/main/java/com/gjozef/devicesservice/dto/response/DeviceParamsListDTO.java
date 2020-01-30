package com.gjozef.devicesservice.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DeviceParamsListDTO extends AbstractListDTO<DeviceParamsDTO> {
    public DeviceParamsListDTO(List<DeviceParamsDTO> data) {
        super((long) data.size(), data);
    }
}
