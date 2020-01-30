package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.Device;
import com.gjozef.devicesservice.dto.response.DeviceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeviceDTOAssembler extends AbstractDomainToDTOAssembler<Device, DeviceDTO> {

    private final DeviceCategoryDTOAssembler deviceCategoryDTOAssembler;

    @Override
    protected void fillInDto(Device domain, DeviceDTO dto) {
        dto.setId(domain.getId());
        dto.setName(domain.getName());
        dto.setDescription(domain.getDescription());
        dto.setDeviceCategory(deviceCategoryDTOAssembler.fromDomain(domain.getDeviceCategory()));
        dto.setDeviceStatus(domain.getDeviceStatus());
    }

    @Override
    protected DeviceDTO createEmptyDto() {
        return new DeviceDTO();
    }
}
