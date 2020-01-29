package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.controller.swagger.DeviceCategoryControllerSwagger;
import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import com.gjozef.devicesservice.dto.response.DeviceCategoryListDTO;
import com.gjozef.devicesservice.service.DeviceCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/device/category")
@RequiredArgsConstructor
public class DeviceCategoryController implements DeviceCategoryControllerSwagger {

    private final DeviceCategoryService deviceCategoryService;

    @Override
    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<DeviceCategoryDTO> getCategory(@PathVariable(name = "categoryId") Long deviceId) {
        return new ResponseEntity<>(deviceCategoryService.getCategory(deviceId), HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/all")
    public ResponseEntity<DeviceCategoryListDTO> getAllCategory() {
        deviceCategoryService.getAllCategories();
        return ResponseEntity.ok().build();
    }

    @Override
    @PostMapping
    public ResponseEntity<DeviceCategoryDTO> addCategory(@RequestBody @Valid DeviceCategoryDTO requestDTO) {
        return new ResponseEntity<>(deviceCategoryService.addCategory(requestDTO), HttpStatus.OK);
    }

    @Override
    @PutMapping(value = "/categoryId")
    public ResponseEntity<DeviceCategoryDTO> editCategory(@PathVariable(name = "categoryId") Long categoryId, @RequestBody @Valid DeviceCategoryDTO requestDTO) {
        return new ResponseEntity<>(deviceCategoryService.editCategory(categoryId, requestDTO), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/categoryId")
    public ResponseEntity<Void> deleteCategory(@PathVariable(name = "categoryId") Long categoryId) {
        deviceCategoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }
}
