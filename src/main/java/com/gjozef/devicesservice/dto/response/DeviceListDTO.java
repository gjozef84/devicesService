package com.gjozef.devicesservice.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DeviceListDTO extends AbstractListDTO<DeviceDTO> {

    public DeviceListDTO(List<DeviceDTO> data) {
        super((long) data.size(), data);
    }
}
