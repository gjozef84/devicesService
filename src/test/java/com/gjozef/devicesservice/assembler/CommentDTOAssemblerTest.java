package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.Comment;
import com.gjozef.devicesservice.domain.Device;
import com.gjozef.devicesservice.dto.response.CommentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class CommentDTOAssemblerTest {

    @Mock
    private DeviceDTOAssembler deviceDTOAssembler;

    private CommentDTOAssembler commentDTOAssembler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        commentDTOAssembler = new CommentDTOAssembler(deviceDTOAssembler);
    }

    @Test
    void fillInDto() {
        Device deviceDomain = mock(Device.class);
        Comment domain = new Comment("content", deviceDomain);
        domain.setId(1L);
        CommentDTO actual = new CommentDTO();
        CommentDTO expected = new CommentDTO(domain.getId(), domain.getContent(), null);

        commentDTOAssembler.fillInDto(domain, actual);
        assertEquals(expected, actual);
    }

    @Test
    void createEmptyDto() {
        CommentDTO expected = new CommentDTO();
        CommentDTO actual = commentDTOAssembler.createEmptyDto();
        assertEquals(expected, actual);
    }
}