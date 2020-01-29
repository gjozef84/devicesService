package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.DeviceCategory;
import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeviceCategoryDTOAssembler extends AbstractDomainToDTOAssembler<DeviceCategory, DeviceCategoryDTO> {

    @Override
    protected void fillInDto(DeviceCategory domain, DeviceCategoryDTO dto) {
        dto.setName(domain.getName());
    }

    @Override
    protected DeviceCategoryDTO createEmptyDto() {
        return new DeviceCategoryDTO();
    }
}
