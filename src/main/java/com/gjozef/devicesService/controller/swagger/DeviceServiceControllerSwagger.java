package com.gjozef.devicesService.controller.swagger;

import com.gjozef.devicesService.dto.response.DeviceDTO;
import com.gjozef.devicesService.dto.response.DeviceListDTO;
import com.gjozef.devicesService.exceptions.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Api(value = "/api/device",
    description = "Resource for handling devices",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface DeviceServiceControllerSwagger {

    @ApiOperation(value = "Get device for given id",
        response = DeviceDTO.class,
        notes = "Get device for given id",
        tags = {"Device"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceDTO> getDevice(Long deviceId) throws ResourceNotFoundException;

    @ApiOperation(value = "Get all device for given id",
        response = DeviceListDTO.class,
        notes = "Get device for given id",
        tags = {"Device"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceListDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceListDTO> getAllDevices() throws ResourceNotFoundException;
}
