package com.gjozef.devicesservice.dto.response;

import com.gjozef.devicesservice.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeviceCategoryDTO implements AbstractDTO {

    private String name;
}
