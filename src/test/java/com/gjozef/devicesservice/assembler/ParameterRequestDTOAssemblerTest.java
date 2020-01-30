package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.Parameter;
import com.gjozef.devicesservice.dto.request.ParameterRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class ParameterRequestDTOAssemblerTest {

    private ParameterRequestDTOAssembler parameterRequestDTOAssembler;

    @BeforeEach
    void setUp() {
        parameterRequestDTOAssembler = new ParameterRequestDTOAssembler();
    }

    @Test
    void fillInDomain() {
        ParameterRequestDTO dto = new ParameterRequestDTO("paramName");
        Parameter actual = new Parameter();
        Parameter expected = new Parameter(dto.getName());

        parameterRequestDTOAssembler.fillInDomain(dto, actual);

        assertEquals(expected, actual);
    }
}