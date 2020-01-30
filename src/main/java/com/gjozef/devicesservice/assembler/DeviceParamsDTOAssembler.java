package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.DeviceParams;
import com.gjozef.devicesservice.dto.response.DeviceDTO;
import com.gjozef.devicesservice.dto.response.DeviceParamsDTO;
import com.gjozef.devicesservice.dto.response.ParameterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeviceParamsDTOAssembler extends AbstractDomainToDTOAssembler<DeviceParams, DeviceParamsDTO> {

    private final DeviceDTOAssembler deviceDTOAssembler;
    private final ParameterDTOAssembler parameterDTOAssembler;

    @Override
    protected void fillInDto(DeviceParams domain, DeviceParamsDTO dto) {
        DeviceDTO deviceDTO = deviceDTOAssembler.fromDomain(domain.getDevice());
        dto.setDeviceDTO(deviceDTO);
        ParameterDTO parameterDTO = parameterDTOAssembler.fromDomain(domain.getParameter());
        dto.setParameterDTO(parameterDTO);
        dto.setValue(domain.getValue());
    }

    @Override
    protected DeviceParamsDTO createEmptyDto() {
        return new DeviceParamsDTO();
    }
}
