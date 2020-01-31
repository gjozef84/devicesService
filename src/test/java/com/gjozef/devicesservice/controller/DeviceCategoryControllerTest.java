package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import com.gjozef.devicesservice.dto.response.DeviceCategoryListDTO;
import com.gjozef.devicesservice.service.DeviceCategoryService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DeviceCategoryControllerTest {

    @Mock
    private DeviceCategoryService deviceCategoryService;

    private DeviceCategoryController deviceCategoryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        deviceCategoryController = new DeviceCategoryController(deviceCategoryService);
    }

    @Test
    public void testGetCategory() {
        Long categoryId = RandomUtils.nextLong();
        DeviceCategoryDTO result = mock(DeviceCategoryDTO.class);
        when(deviceCategoryService.getCategory(categoryId)).thenReturn(result);

        final ResponseEntity<DeviceCategoryDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<DeviceCategoryDTO> actual = deviceCategoryController.getCategory(categoryId);

        assertEquals(expected, actual);
        verify(deviceCategoryService).getCategory(anyLong());
    }

    @Test
    public void testGetAllCategories() {
        DeviceCategoryListDTO result = mock(DeviceCategoryListDTO.class);
        when(deviceCategoryService.getAllCategories()).thenReturn(result);

        final ResponseEntity<DeviceCategoryListDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<DeviceCategoryListDTO> actual = deviceCategoryController.getAllCategories();

        assertEquals(expected, actual);
        verify(deviceCategoryService).getAllCategories();
    }

    @Test
    public void testAddCategory() {
        DeviceCategoryDTO result = mock(DeviceCategoryDTO.class);
        DeviceCategoryDTO requestDTO = mock(DeviceCategoryDTO.class);
        when(deviceCategoryService.addCategory(requestDTO)).thenReturn(result);

        final ResponseEntity<DeviceCategoryDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<DeviceCategoryDTO> actual = deviceCategoryController.addCategory(requestDTO);

        assertEquals(expected, actual);
        verify(deviceCategoryService).addCategory(any(DeviceCategoryDTO.class));
    }

    @Test
    public void testEditCategory() {
        Long categoryId = RandomUtils.nextLong();
        DeviceCategoryDTO result = mock(DeviceCategoryDTO.class);
        DeviceCategoryDTO requestDTO = mock(DeviceCategoryDTO.class);
        when(deviceCategoryService.editCategory(categoryId, requestDTO)).thenReturn(result);

        final ResponseEntity<DeviceCategoryDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<DeviceCategoryDTO> actual = deviceCategoryController.editCategory(categoryId, requestDTO);

        assertEquals(expected, actual);
        verify(deviceCategoryService).editCategory(anyLong(), any(DeviceCategoryDTO.class));
    }

    @Test
    public void testDeleteCategory() {
        Long categoryId = RandomUtils.nextLong();
        doNothing().when(deviceCategoryService).deleteCategory(categoryId);

        final ResponseEntity<Void> expected = new ResponseEntity<>(HttpStatus.OK);
        final ResponseEntity<Void> actual = deviceCategoryController.deleteCategory(categoryId);

        assertEquals(expected, actual);
        verify(deviceCategoryService).deleteCategory(anyLong());
    }
}