package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.Comment;
import com.gjozef.devicesservice.dto.response.CommentDTO;
import com.gjozef.devicesservice.dto.response.DeviceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentDTOAssembler extends AbstractDomainToDTOAssembler<Comment, CommentDTO> {

    private final DeviceDTOAssembler deviceDTOAssembler;

    @Override
    protected void fillInDto(Comment domain, CommentDTO dto) {
        dto.setId(domain.getId());
        dto.setContent(domain.getContent());
        DeviceDTO deviceDTO = deviceDTOAssembler.fromDomain(domain.getDevice());
        dto.setDeviceDTO(deviceDTO);
    }

    @Override
    protected CommentDTO createEmptyDto() {
        return new CommentDTO();
    }
}
