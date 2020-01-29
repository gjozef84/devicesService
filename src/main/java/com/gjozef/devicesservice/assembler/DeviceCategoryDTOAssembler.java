package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.DeviceCategory;
import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class DeviceCategoryDTOAssembler extends AbstractDomainToDTOAssembler<DeviceCategory, DeviceCategoryDTO> {

    @Override
    protected void fillInDto(DeviceCategory domain, DeviceCategoryDTO dto) {
        dto.setName(domain.getName());
    }

    @Override
    protected DeviceCategoryDTO createEmptyDto() {
        return new DeviceCategoryDTO();
    }

    public DeviceCategory toDomain(DeviceCategoryDTO dto) {
        return new DeviceCategory(dto.getName());
    }

    public void fillInDomain(DeviceCategoryDTO dto, DeviceCategory domain) {
        domain.setName(dto.getName());
    }
}
