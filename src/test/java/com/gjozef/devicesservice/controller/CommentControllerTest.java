package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.dto.request.CommentRequestDTO;
import com.gjozef.devicesservice.dto.response.CommentDTO;
import com.gjozef.devicesservice.dto.response.CommentListDTO;
import com.gjozef.devicesservice.service.CommentService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CommentControllerTest {

    @Mock
    private CommentService commentService;

    private CommentController commentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        commentController = new CommentController(commentService);
    }

    @Test
    public void testGetDeviceComment() {
        Long deviceId = RandomUtils.nextLong();
        Long commentId = RandomUtils.nextLong();
        CommentDTO result = mock(CommentDTO.class);
        when(commentService.getDeviceComment(deviceId, commentId)).thenReturn(result);
        final ResponseEntity<CommentDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<CommentDTO> actual = commentController.getDeviceComment(deviceId, commentId);

        assertEquals(expected, actual);
        verify(commentService).getDeviceComment(anyLong(), anyLong());
    }

    @Test
    public void testGetDeviceComments() {
        Long deviceId = RandomUtils.nextLong();
        CommentListDTO result = mock(CommentListDTO.class);
        when(commentService.getDeviceComments(deviceId)).thenReturn(result);
        final ResponseEntity<CommentListDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<CommentListDTO> actual = commentController.getDeviceComments(deviceId);

        assertEquals(expected, actual);
        verify(commentService).getDeviceComments(anyLong());
    }

    @Test
    public void testAddComment() {
        Long deviceId = RandomUtils.nextLong();
        CommentDTO result = mock(CommentDTO.class);
        CommentRequestDTO requestDTO = mock(CommentRequestDTO.class);
        when(commentService.addComment(deviceId, requestDTO)).thenReturn(result);

        final ResponseEntity<CommentDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<CommentDTO> actual = commentController.addComment(deviceId, requestDTO);

        assertEquals(expected, actual);
        verify(commentService).addComment(anyLong(), any(CommentRequestDTO.class));
    }

    @Test
    public void testEditComment() {
        Long deviceId = RandomUtils.nextLong();
        Long commentId = RandomUtils.nextLong();
        CommentDTO result = mock(CommentDTO.class);
        CommentRequestDTO requestDTO = mock(CommentRequestDTO.class);
        when(commentService.editComment(deviceId, commentId, requestDTO)).thenReturn(result);

        final ResponseEntity<CommentDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<CommentDTO> actual = commentController.editComment(deviceId, commentId, requestDTO);

        assertEquals(expected, actual);
        verify(commentService).editComment(anyLong(), anyLong(), any(CommentRequestDTO.class));
    }

    @Test
    public void testDeleteComment() {
        Long deviceId = RandomUtils.nextLong();
        Long commentId = RandomUtils.nextLong();
        doNothing().when(commentService).deleteComment(deviceId, commentId);

        final ResponseEntity<Void> expected = new ResponseEntity<>(HttpStatus.OK);
        final ResponseEntity<Void> actual = commentController.deleteComment(deviceId, commentId);

        assertEquals(expected, actual);
        verify(commentService).deleteComment(anyLong(), anyLong());
    }
}