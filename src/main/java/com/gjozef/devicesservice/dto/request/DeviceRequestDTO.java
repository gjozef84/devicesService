package com.gjozef.devicesservice.dto.request;

import com.gjozef.devicesservice.domain.DeviceStatus;
import com.gjozef.devicesservice.dto.AbstractDTO;
import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class DeviceRequestDTO implements AbstractDTO {
    @NotBlank
    @Size(max = 200)
    private String name;
    @Size(max = 500)
    private String description;
    @NotNull
    private DeviceCategoryDTO deviceCategory;
    private DeviceStatus deviceStatus;
}
