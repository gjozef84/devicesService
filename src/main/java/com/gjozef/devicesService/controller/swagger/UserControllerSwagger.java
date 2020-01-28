package com.gjozef.devicesService.controller.swagger;

import com.gjozef.devicesService.dto.UserListDTO;
import com.gjozef.devicesService.dto.request.UserRequestDTO;
import com.gjozef.devicesService.dto.response.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api(value = "/api/users",
    description = "Resource for handling users")
public interface UserControllerSwagger {

    @ApiOperation(value = "Create user for request",
        response = UserDTO.class,
        notes = "Create user",
        tags = {"Users"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = UserDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<UserDTO> addUser(UserRequestDTO userRequestDTO);

    @ApiOperation(value = "Edit user for request",
        response = UserDTO.class,
        notes = "Edit user",
        tags = {"Users"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = UserDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<UserDTO> editUser(Long userId, UserRequestDTO userRequestDTO);

    @ApiOperation(value = "Get user for given userId",
        response = UserDTO.class,
        notes = "Get user for given userId",
        tags = {"Users"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = UserDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<UserDTO> getUser(Long userId);

    @ApiOperation(value = "Get all active users",
        response = UserListDTO.class,
        notes = "Get all active users",
        tags = {"Users"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = UserListDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<UserListDTO> getAllUsers();

    @ApiOperation(value = "Delete user for given userId",
        notes = "Delete user for given userId",
        tags = {"Users"})
    @ApiResponses(value = {
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<Void> deleteUser(Long userId);
}
