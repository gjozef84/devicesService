package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.Parameter;
import com.gjozef.devicesservice.dto.response.ParameterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ParameterDTOAssemblerTest {

    private ParameterDTOAssembler parameterDTOAssembler;

    @BeforeEach
    void setUp() {
        parameterDTOAssembler = new ParameterDTOAssembler();
    }

    @Test
    public void fillInDto() {
        Parameter domain = new Parameter("paramName");
        domain.setId(1L);
        ParameterDTO expected = new ParameterDTO(domain.getId(), domain.getName());

        ParameterDTO actual = parameterDTOAssembler.fromDomain(domain);

        assertEquals(expected, actual);
    }

    @Test
    public void createEmptyDto() {
        ParameterDTO expected = new ParameterDTO();

        ParameterDTO actual = parameterDTOAssembler.createEmptyDto();
        assertEquals(expected, actual);
    }
}