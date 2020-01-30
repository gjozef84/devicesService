package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.Parameter;
import com.gjozef.devicesservice.dto.response.ParameterDTO;
import org.springframework.stereotype.Component;

@Component
public class ParameterDTOAssembler extends AbstractDomainToDTOAssembler<Parameter, ParameterDTO> {

    @Override
    protected void fillInDto(Parameter domain, ParameterDTO dto) {
        dto.setId(domain.getId());
        dto.setParamName(domain.getName());
    }

    @Override
    protected ParameterDTO createEmptyDto() {
        return new ParameterDTO();
    }
}
