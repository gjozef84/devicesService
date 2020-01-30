package com.gjozef.devicesservice.service.impl;

import com.gjozef.devicesservice.assembler.CommentDTOAssembler;
import com.gjozef.devicesservice.domain.Comment;
import com.gjozef.devicesservice.domain.Device;
import com.gjozef.devicesservice.dto.request.CommentRequestDTO;
import com.gjozef.devicesservice.dto.response.CommentDTO;
import com.gjozef.devicesservice.dto.response.CommentListDTO;
import com.gjozef.devicesservice.exceptions.ResourceNotFoundException;
import com.gjozef.devicesservice.repository.CommentRepository;
import com.gjozef.devicesservice.service.CommentService;
import com.gjozef.devicesservice.service.DeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final DeviceService deviceService;
    private final CommentDTOAssembler commentDTOAssembler;

    @Override
    public CommentListDTO getDeviceComments(Long deviceId) {
        log.info("getDeviceComments() deviceId={}", deviceId);
        List<Comment> deviceComments = commentRepository.findAllByDeviceIdAndActiveTrue();
        if (CollectionUtils.isNotEmpty(deviceComments)) {
            return new CommentListDTO(deviceComments.stream()
                .map(commentDTOAssembler::fromDomain)
                .collect(Collectors.toList()));
        }
        return new CommentListDTO();
    }

    @Override
    public CommentDTO getDeviceComment(Long deviceId, Long commentId) {
        log.info("getDeviceComment() deviceId={}, commentId={}", deviceId, commentId);
        return commentDTOAssembler.fromDomain(fetchComment(deviceId, commentId));
    }

    @Override
    public CommentDTO addComment(Long deviceId, CommentRequestDTO requestDTO) {
        log.info("addComment() for deviceId={} using requestDTO={}", deviceId, requestDTO);
        Device device = deviceService.fetchDevice(deviceId);
        Comment comment = new Comment();
        comment.setDevice(device);
        comment.setContent(requestDTO.getContent());
        return commentDTOAssembler.fromDomain(commentRepository.save(comment));
    }

    @Override
    public CommentDTO editComment(Long deviceId, Long commentId, CommentRequestDTO requestDTO) {
        log.info("editComment() deviceId={}, commentId={}", deviceId, commentId);
        Comment comment = fetchComment(deviceId, commentId);
        comment.setContent(requestDTO.getContent());
        return commentDTOAssembler.fromDomain(commentRepository.save(comment));
    }

    @Override
    public void deleteComment(Long deviceId, Long commentId) {
        log.info("deleteComment() deviceId={}, commentId={}", deviceId, commentId);
        Comment comment = fetchComment(deviceId, commentId);
        comment.setActive(false);
        commentRepository.save(comment);
    }

    private Comment fetchComment(Long deviceId, Long commentId) {
        return commentRepository.findByIdAndDeviceIdAndActiveTrue(deviceId, commentId)
            .orElseThrow(() -> new ResourceNotFoundException(Comment.class, "id", commentId.toString()));
    }
}
