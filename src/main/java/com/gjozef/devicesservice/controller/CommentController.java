package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.controller.swagger.CommentControllerSwagger;
import com.gjozef.devicesservice.dto.request.CommentRequestDTO;
import com.gjozef.devicesservice.dto.response.CommentDTO;
import com.gjozef.devicesservice.dto.response.CommentListDTO;
import com.gjozef.devicesservice.service.CommentService;
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
@RequestMapping("/api/device/{deviceId}")
@RequiredArgsConstructor
public class CommentController implements CommentControllerSwagger {

    private final CommentService commentService;

    @Override
    @GetMapping("/comment/{commentId}")
    public ResponseEntity<CommentDTO> getDeviceComment(@PathVariable(name = "deviceId") Long deviceId, @PathVariable(name = "commentId") Long commentId) {
        return new ResponseEntity<CommentDTO>(commentService.getDeviceComment(deviceId, commentId), HttpStatus.OK);
    }

    @Override
    @GetMapping("/comment")
    public ResponseEntity<CommentListDTO> getDeviceComments(@PathVariable(name = "deviceId") Long deviceId) {
        return new ResponseEntity<CommentListDTO>(commentService.getDeviceComments(deviceId), HttpStatus.OK);
    }

    @Override
    @PostMapping("/comment")
    public ResponseEntity<CommentDTO> addComment(@PathVariable(name = "deviceId") Long deviceId, @RequestBody @Valid CommentRequestDTO requestDTO) {
        return new ResponseEntity<>(commentService.addComment(deviceId, requestDTO), HttpStatus.OK);
    }

    @Override
    @PutMapping("/comment/{commentId}")
    public ResponseEntity<CommentDTO> editComment(@PathVariable(name = "deviceId") Long deviceId, @PathVariable(name = "commentId") Long commentId,
                                                  @RequestBody @Valid CommentRequestDTO requestDTO) {
        return new ResponseEntity<>(commentService.editComment(deviceId, commentId, requestDTO), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity deleteComment(@PathVariable(name = "deviceId") Long deviceId, @PathVariable(name = "commentId") Long commentId) {
        commentService.deleteComment(deviceId, commentId);
        return ResponseEntity.ok().build();
    }
}
