package com.gjozef.devicesservice.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DeviceCategoryListDTO extends AbstractListDTO<DeviceCategoryDTO> {
    public DeviceCategoryListDTO(List<DeviceCategoryDTO> data) {
        super((long) data.size(), data);
    }
}
