package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.Device;
import com.gjozef.devicesservice.domain.DeviceCategory;
import com.gjozef.devicesservice.domain.DeviceStatus;
import com.gjozef.devicesservice.dto.request.DeviceRequestDTO;
import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DeviceRequestDTOAssemblerTest {

    @Mock
    private DeviceCategoryDTOAssembler deviceCategoryDTOAssembler;

    private DeviceRequestDTOAssembler deviceRequestDTOAssembler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        deviceRequestDTOAssembler = new DeviceRequestDTOAssembler(deviceCategoryDTOAssembler);
    }

    @Test
    public void testToDomain() {
        DeviceCategory deviceCategory = new DeviceCategory("deviceCategoryDTO");
        deviceCategory.setId(1L);
        DeviceCategoryDTO deviceCategoryDTO = new DeviceCategoryDTO(deviceCategory.getId(), deviceCategory.getName());
        DeviceRequestDTO dto = new DeviceRequestDTO("deviceName", "description", deviceCategoryDTO, DeviceStatus.SPRAWNY);
        Device expected = new Device(dto.getName(), dto.getDescription(), deviceCategory, dto.getDeviceStatus());
        when(deviceCategoryDTOAssembler.toDomain(deviceCategoryDTO)).thenReturn(deviceCategory);

        Device actual = deviceRequestDTOAssembler.toDomain(dto);

        assertEquals(expected, actual);
    }

    @Test
    public void testFillInDomain(){
        DeviceCategory deviceCategory = new DeviceCategory("deviceCategoryDTO");
        deviceCategory.setId(5L);
        DeviceCategoryDTO deviceCategoryDTO = new DeviceCategoryDTO(deviceCategory.getId(), deviceCategory.getName());
        DeviceRequestDTO dto = new DeviceRequestDTO("deviceName", "description", deviceCategoryDTO, DeviceStatus.SPRAWNY);
        Device domain = new Device();
        Device expected = new Device(dto.getName(), dto.getDescription(), deviceCategory, dto.getDeviceStatus());
        when(deviceCategoryDTOAssembler.toDomain(deviceCategoryDTO)).thenReturn(deviceCategory);

        deviceRequestDTOAssembler.fillInDomain(dto, domain);

        assertEquals(expected, domain);
    }
}