package com.gjozef.devicesservice.controller.swagger;

import com.gjozef.devicesservice.dto.request.CommentRequestDTO;
import com.gjozef.devicesservice.dto.response.CommentDTO;
import com.gjozef.devicesservice.dto.response.CommentListDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api(value = "/api/device/{deviceId}",
    description = "Resource for handling device comments")
public interface CommentControllerSwagger {

    @ApiOperation(value = "Get device comment for given commentId",
        response = CommentDTO.class,
        notes = "Get device comment for given commentId",
        tags = {"Comments"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = CommentDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<CommentDTO> getDeviceComment(Long deviceId, Long commentId);

    @ApiOperation(value = "Get all device comments",
        response = CommentListDTO.class,
        notes = "Get all device comments",
        tags = {"Comments"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = CommentListDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<CommentListDTO> getDeviceComments(Long deviceId);

    @ApiOperation(value = "Create new device comment for given requestDTO",
        response = CommentDTO.class,
        notes = "Create new device comment",
        tags = {"Comments"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = CommentDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<CommentDTO> addComment(Long deviceId, CommentRequestDTO requestDTO);

    @ApiOperation(value = "Edit device comment for given requestDTO",
        response = CommentDTO.class,
        notes = "Edit device comment",
        tags = {"Comments"})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = CommentDTO.class),
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity<CommentDTO> editComment(Long deviceId, Long commentId, CommentRequestDTO requestDTO);

    @ApiOperation(value = "Delete comment for given commentId",
        notes = "Delete comment for given commentId",
        tags = {"Comments"})
    @ApiResponses(value = {
        @ApiResponse(code = 401, message = "In case of unauthorized access"),
        @ApiResponse(code = 500, message = "In case of any exception")})
    ResponseEntity deleteComment(Long deviceId, Long commentId);
}
