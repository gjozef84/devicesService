package com.gjozef.devicesservice.dto.response;

import com.gjozef.devicesservice.domain.DeviceStatus;
import com.gjozef.devicesservice.dto.AbstractDTO;
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
