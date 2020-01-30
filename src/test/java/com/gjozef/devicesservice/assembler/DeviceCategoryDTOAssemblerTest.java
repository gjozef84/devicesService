package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.DeviceCategory;
import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DeviceCategoryDTOAssemblerTest {

    private DeviceCategoryDTOAssembler deviceCategoryDTOAssembler;

    @BeforeEach
    public void setUp() {
        deviceCategoryDTOAssembler = new DeviceCategoryDTOAssembler();
    }

    @Test
    public void fillInDto() {
        DeviceCategory domain = new DeviceCategory("name");
        domain.setId(1L);
        DeviceCategoryDTO expected = new DeviceCategoryDTO(domain.getId(), domain.getName());
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