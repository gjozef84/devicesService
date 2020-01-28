package com.gjozef.devicesService.dto.response;

import com.gjozef.devicesService.domain.DeviceStatus;
import com.gjozef.devicesService.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeviceDTO implements AbstractDTO {

    private String name;
    private DeviceCategoryDTO deviceCategory;
    private DeviceStatus deviceStatus;
}
