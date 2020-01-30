package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.Device;
import com.gjozef.devicesservice.dto.request.DeviceRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public class DeviceRequestDTOAssembler implements DTOToDomainAssembler<Device, DeviceRequestDTO> {

    private final DeviceCategoryDTOAssembler deviceCategoryDTOAssembler;

    @Override
    public Device toDomain(DeviceRequestDTO dto) {
        Assert.notNull(dto, "DTO cannot be null");

        Device domain = new Device();
        fillInDomain(dto, domain);

        return domain;
    }

    @Override
    public void fillInDomain(DeviceRequestDTO dto, Device domain) {
        domain.setName(dto.getName());
        domain.setDescription(dto.getDescription());
        domain.setDeviceCategory(deviceCategoryDTOAssembler.toDomain(dto.getDeviceCategory()));
        domain.setDeviceStatus(dto.getDeviceStatus());
    }
}
