package com.gjozef.devicesservice.controller.swagger;

import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import com.gjozef.devicesservice.dto.response.DeviceCategoryListDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Api(value = "/api/device/category",
    description = "Resource for handling device categories",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface DeviceCategoryControllerSwagger {

    @ApiOperation(value = "Get device for given categoryId",
        response = DeviceCategoryDTO.class,
        notes = "Get device for given categoryId",
        tags = {"Categories"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceCategoryDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceCategoryDTO> getCategory(Long deviceId);

    @ApiOperation(value = "Get all device categories",
        response = DeviceCategoryListDTO.class,
        notes = "Get all device categories",
        tags = {"Categories"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceCategoryListDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceCategoryListDTO> getAllCategory();

    @ApiOperation(value = "Create new device category for given requestDTO",
        response = DeviceCategoryDTO.class,
        notes = "Create new device category",
        tags = {"Categories"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceCategoryDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceCategoryDTO> addCategory(DeviceCategoryDTO requestDTO);

    @ApiOperation(value = "Edit device category for given requestDTO",
        response = DeviceCategoryDTO.class,
        notes = "Edit device category",
        tags = {"Categories"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceCategoryDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceCategoryDTO> editCategory(Long categoryId, DeviceCategoryDTO requestDTO);

    @ApiOperation(value = "Delete category for given categoryId",
        notes = "Delete category for given categoryId",
        tags = {"Categories"})
    @ApiResponses(value = {
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<Void> deleteCategory(Long categoryId);
}
