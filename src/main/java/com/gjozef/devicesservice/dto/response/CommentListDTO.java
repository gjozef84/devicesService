package com.gjozef.devicesservice.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CommentListDTO extends AbstractListDTO<CommentDTO> {
    public CommentListDTO(List<CommentDTO> data) {
        super((long) data.size(), data);
    }
}
