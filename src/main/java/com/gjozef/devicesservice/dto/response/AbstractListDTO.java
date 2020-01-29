package com.gjozef.devicesservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractListDTO<T> {

    private Long totalCount;
    private List<T> data;
}
