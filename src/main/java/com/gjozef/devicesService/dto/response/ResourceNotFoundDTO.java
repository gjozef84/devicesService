package com.gjozef.devicesService.dto.response;

import com.gjozef.devicesService.dto.AbstractDTO;
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