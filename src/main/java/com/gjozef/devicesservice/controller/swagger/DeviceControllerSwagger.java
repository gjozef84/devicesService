package com.gjozef.devicesservice.controller.swagger;

import com.gjozef.devicesservice.domain.DeviceStatus;
import com.gjozef.devicesservice.dto.request.DeviceRequestDTO;
import com.gjozef.devicesservice.dto.request.ParameterValueRequestDTO;
import com.gjozef.devicesservice.dto.response.DeviceDTO;
import com.gjozef.devicesservice.dto.response.DeviceListDTO;
import com.gjozef.devicesservice.dto.response.DeviceParamsDTO;
import com.gjozef.devicesservice.dto.response.DeviceParamsListDTO;
import com.gjozef.devicesservice.exceptions.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api(value = "/api/device",
    description = "Resource for handling devices")
public interface DeviceControllerSwagger {

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

    @ApiOperation(value = "Add new device parameter for given requestDTO",
        response = DeviceParamsDTO.class,
        notes = "Add new device parameter",
        tags = {"Device", "Parameter"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceParamsDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceParamsDTO> addParamToDevice(Long deviceId, Long paramId, ParameterValueRequestDTO parameterValueRequestDTO);

    @ApiOperation(value = "Get all device parameters for given deviceId",
        response = DeviceParamsListDTO.class,
        notes = "Get all device parameters",
        tags = {"Device", "Parameter"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceParamsListDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceParamsListDTO> getAllDeviceParams(Long deviceId);

    @ApiOperation(value = "Change device status for given deviceId and status",
        response = DeviceDTO.class,
        notes = "Change device status",
        tags = {"Device", "Status"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = DeviceDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<DeviceDTO> changeDeviceStatus(Long deviceId, DeviceStatus deviceStatus);
}
