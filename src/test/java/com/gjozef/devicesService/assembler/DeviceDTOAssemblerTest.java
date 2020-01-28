package com.gjozef.devicesService.assembler;

import com.gjozef.devicesService.domain.Device;
import com.gjozef.devicesService.domain.DeviceCategory;
import com.gjozef.devicesService.domain.DeviceStatus;
import com.gjozef.devicesService.dto.response.DeviceCategoryDTO;
import com.gjozef.devicesService.dto.response.DeviceDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DeviceDTOAssemblerTest {

    @Mock
    private DeviceCategoryDTOAssembler deviceCategoryDTOAssembler;

    private DeviceDTOAssembler deviceDTOAssembler;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        deviceDTOAssembler = new DeviceDTOAssembler(deviceCategoryDTOAssembler);
    }

    @Test
    public void fillInDto() {
        DeviceCategory deviceCategory = new DeviceCategory("name");
        DeviceCategoryDTO deviceCategoryDTO = new DeviceCategoryDTO(deviceCategory.getName());
        Device domain = new Device("name", deviceCategory, DeviceStatus.SPRAWNY);
        DeviceDTO expected = new DeviceDTO(domain.getName(), deviceCategoryDTO, domain.getDeviceStatus());

        when(deviceCategoryDTOAssembler.fromDomain(deviceCategory)).thenReturn(deviceCategoryDTO);

        assertEquals(expected, deviceDTOAssembler.fromDomain(domain));
    }

    @Test
    public void createEmptyDto() {
        DeviceDTO expected = new DeviceDTO();

        DeviceDTO actual = deviceDTOAssembler.createEmptyDto();

        assertEquals(expected, actual);
    }
}