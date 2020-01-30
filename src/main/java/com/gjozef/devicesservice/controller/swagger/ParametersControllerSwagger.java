package com.gjozef.devicesservice.controller.swagger;

import com.gjozef.devicesservice.dto.request.ParameterRequestDTO;
import com.gjozef.devicesservice.dto.response.ParameterDTO;
import com.gjozef.devicesservice.dto.response.ParameterListDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Api(value = "/api/parameters",
    description = "Resource for handling device parametere",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface ParametersControllerSwagger {

    @ApiOperation(value = "Get parameter for given Id",
        response = ParameterDTO.class,
        notes = "Get parameter for given Id",
        tags = {"Parameters"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = ParameterDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<ParameterDTO> getParameter(Long parameterId);

    @ApiOperation(value = "Get all parameters",
        response = ParameterListDTO.class,
        notes = "Get all parameters",
        tags = {"Parameters"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = ParameterListDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<ParameterListDTO> getAllParameters();

    @ApiOperation(value = "Create new parameter for given requestDTO",
        response = ParameterDTO.class,
        notes = "Create new parameter",
        tags = {"Parameters"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = ParameterDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<ParameterDTO> addParameter(ParameterRequestDTO requestDTO);

    @ApiOperation(value = "Edit parameter for given requestDTO",
        response = ParameterDTO.class,
        notes = "Edit parameter",
        tags = {"Parameters"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = ParameterDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<ParameterDTO> editParameter(Long parameterId, ParameterRequestDTO requestDTO);

    @ApiOperation(value = "Delete parameter for given categoryId",
        notes = "Delete parameter for given categoryId",
        tags = {"Parameters"})
    @ApiResponses(value = {
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<Void> deleteParameter(Long parameterId);
}
