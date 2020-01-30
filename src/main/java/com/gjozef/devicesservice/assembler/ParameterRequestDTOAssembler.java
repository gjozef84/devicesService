package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.Parameter;
import com.gjozef.devicesservice.dto.request.ParameterRequestDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ParameterRequestDTOAssembler implements DTOToDomainAssembler<Parameter, ParameterRequestDTO> {

    @Override
    public Parameter toDomain(ParameterRequestDTO dto) {
        Assert.notNull(dto, "DTO cannot be null");

        Parameter domain = new Parameter();
        fillInDomain(dto, domain);

        return domain;
    }

    @Override
    public void fillInDomain(ParameterRequestDTO dto, Parameter domain) {
        domain.setName(dto.getName());
    }
}
