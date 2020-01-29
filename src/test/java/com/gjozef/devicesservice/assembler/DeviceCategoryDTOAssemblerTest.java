package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.DeviceCategory;
import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeviceCategoryDTOAssemblerTest {

    private DeviceCategoryDTOAssembler deviceCategoryDTOAssembler;

    @BeforeEach
    void setUp() {
        deviceCategoryDTOAssembler = new DeviceCategoryDTOAssembler();
    }

    @Test
    public void fillInDto() {
        DeviceCategory domain = new DeviceCategory("name");
        DeviceCategoryDTO expected = new DeviceCategoryDTO(domain.getName());

        DeviceCategoryDTO actual = deviceCategoryDTOAssembler.fromDomain(domain);
        assertEquals(expected, actual);
    }

    @Test
    public void createEmptyDto() {
        DeviceCategoryDTO expected = new DeviceCategoryDTO();

        DeviceCategoryDTO actual = deviceCategoryDTOAssembler.createEmptyDto();

        assertEquals(expected, actual);
    }
}