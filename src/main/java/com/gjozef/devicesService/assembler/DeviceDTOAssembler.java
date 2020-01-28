package com.gjozef.devicesService.assembler;

import com.gjozef.devicesService.domain.Device;
import com.gjozef.devicesService.dto.response.DeviceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeviceDTOAssembler extends AbstractDomainToDTOAssembler<Device, DeviceDTO> {

    private final DeviceCategoryDTOAssembler deviceCategoryDTOAssembler;

    @Override
    protected void fillInDto(Device domain, DeviceDTO dto) {
        dto.setName(domain.getName());
        dto.setDeviceCategory(deviceCategoryDTOAssembler.fromDomain(domain.getDeviceCategory()));
        dto.setDeviceStatus(domain.getDeviceStatus());
    }

    @Override
    protected DeviceDTO createEmptyDto() {
        return new DeviceDTO();
    }
}
