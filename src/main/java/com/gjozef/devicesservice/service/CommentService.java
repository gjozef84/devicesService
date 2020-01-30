package com.gjozef.devicesservice.service;

import com.gjozef.devicesservice.dto.request.CommentRequestDTO;
import com.gjozef.devicesservice.dto.response.CommentDTO;
import com.gjozef.devicesservice.dto.response.CommentListDTO;

public interface CommentService {
    CommentListDTO getDeviceComments(Long deviceId);

    CommentDTO getDeviceComment(Long deviceId, Long commentId);

    CommentDTO addComment(Long deviceId, CommentRequestDTO requestDTO);

    CommentDTO editComment(Long deviceId, Long commentId, CommentRequestDTO requestDTO);

    void deleteComment(Long deviceId, Long commentId);
}
