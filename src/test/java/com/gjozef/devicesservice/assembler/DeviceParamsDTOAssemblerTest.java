package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.Device;
import com.gjozef.devicesservice.domain.DeviceParams;
import com.gjozef.devicesservice.domain.Parameter;
import com.gjozef.devicesservice.dto.response.DeviceParamsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class DeviceParamsDTOAssemblerTest {

    @Mock
    private DeviceDTOAssembler deviceDTOAssembler;
    @Mock
    private ParameterDTOAssembler parameterDTOAssembler;

    private DeviceParamsDTOAssembler deviceParamsDTOAssembler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        deviceParamsDTOAssembler = new DeviceParamsDTOAssembler(deviceDTOAssembler, parameterDTOAssembler);
    }

    @Test
    void testFillInDto() {
        Device device = new Device();
        Parameter parameter = new Parameter();
        DeviceParams domain = new DeviceParams(device, parameter, "value");
        DeviceParamsDTO dto = new DeviceParamsDTO();
        DeviceParamsDTO expected = new DeviceParamsDTO(null, null, domain.getValue());

        deviceParamsDTOAssembler.fillInDto(domain, dto);

        assertEquals(expected, dto);
    }

    @Test
    void testCreateEmptyDto() {
        DeviceParamsDTO expected = new DeviceParamsDTO();
        DeviceParamsDTO actual = deviceParamsDTOAssembler.createEmptyDto();
        assertEquals(expected, actual);
    }
}