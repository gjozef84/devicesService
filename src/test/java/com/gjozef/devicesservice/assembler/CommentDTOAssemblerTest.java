package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.Comment;
import com.gjozef.devicesservice.domain.Device;
import com.gjozef.devicesservice.dto.response.CommentDTO;
import com.gjozef.devicesservice.dto.response.DeviceDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        DeviceDTO deviceDTO = mock(DeviceDTO.class);
        Comment domain = new Comment("content", deviceDomain);
        CommentDTO dto = new CommentDTO();
        CommentDTO expected = new CommentDTO(domain.getContent(), deviceDTO);
        when(deviceDTOAssembler.fromDomain(deviceDomain)).thenReturn(deviceDTO);

        commentDTOAssembler.fillInDto(domain, dto);
        assertEquals(expected, dto);
    }

    @Test
    void createEmptyDto() {
        CommentDTO expected = new CommentDTO();
        CommentDTO actual = commentDTOAssembler.createEmptyDto();
        assertEquals(expected, actual);
    }
}