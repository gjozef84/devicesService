package com.gjozef.devicesservice.controller.swagger;

import com.gjozef.devicesservice.dto.request.DeviceRequestDTO;
import com.gjozef.devicesservice.dto.response.DeviceDTO;
import com.gjozef.devicesservice.dto.response.DeviceListDTO;
import com.gjozef.devicesservice.exceptions.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api(value = "/api/device",
    description = "Resource for handling devices")
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

    @ApiOperation(value = "Get all devices",
        response = DeviceListDTO.class,
        notes = "Get all devices",
        tags = {"Device"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceListDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceListDTO> getAllDevices() throws ResourceNotFoundException;

    @ApiOperation(value = "Create new device for given requestDTO",
        response = DeviceDTO.class,
        notes = "Create new device",
        tags = {"Device"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceDTO> addDevice(DeviceRequestDTO deviceRequestDTO) throws ResourceNotFoundException;

    @ApiOperation(value = "Edit device for given requestDTO",
        response = DeviceDTO.class,
        notes = "Edit device",
        tags = {"Device"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceDTO> editDevice(Long deviceId, DeviceRequestDTO deviceRequestDTO) throws ResourceNotFoundException;

    @ApiOperation(value = "Delete device for given id",
        notes = "Delete device for given id",
        tags = {"Device"})
    @ApiResponses(value = {
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<Void> deleteDevice(Long deviceId);
}
