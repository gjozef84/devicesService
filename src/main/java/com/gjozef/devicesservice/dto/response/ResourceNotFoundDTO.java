package com.gjozef.devicesservice.dto.response;

import com.gjozef.devicesservice.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResourceNotFoundDTO implements AbstractDTO {

    private String type;
    private String propertyName;
    private String propertyValue;

}