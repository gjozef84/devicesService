package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.DeviceCategory;
import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DeviceCategoryDTOAssemblerTest {

    private final DeviceCategoryDTOAssembler deviceCategoryDTOAssembler = new DeviceCategoryDTOAssembler();

    @Test
    public void testFillInDto() {
        DeviceCategory domain = new DeviceCategory("name");
        domain.setId(1L);
        DeviceCategoryDTO expected = new DeviceCategoryDTO(domain.getId(), domain.getName());
        DeviceCategoryDTO actual = deviceCategoryDTOAssembler.fromDomain(domain);

        assertEquals(expected, actual);
    }

    @Test
    public void testCreateEmptyDto() {
        DeviceCategoryDTO expected = new DeviceCategoryDTO();

        DeviceCategoryDTO actual = deviceCategoryDTOAssembler.createEmptyDto();

        assertEquals(expected, actual);
    }

    @Test
    public void testToDomain() {
        DeviceCategoryDTO dto = new DeviceCategoryDTO(1L, "name");
        DeviceCategory expected = new DeviceCategory(dto.getName());
        DeviceCategory actual = deviceCategoryDTOAssembler.toDomain(dto);
        assertEquals(expected, actual);
    }

    @Test
    public void testFillInDomain() {
        DeviceCategoryDTO dto = new DeviceCategoryDTO(1L, "name");
        DeviceCategory domain = new DeviceCategory();
        DeviceCategory expected = new DeviceCategory(dto.getName());
        deviceCategoryDTOAssembler.fillInDomain(dto, domain);
        assertEquals(expected, domain);
    }
}