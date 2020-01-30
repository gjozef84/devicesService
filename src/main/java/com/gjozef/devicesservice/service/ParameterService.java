package com.gjozef.devicesservice.service;

import com.gjozef.devicesservice.dto.request.ParameterRequestDTO;
import com.gjozef.devicesservice.dto.response.ParameterDTO;
import com.gjozef.devicesservice.dto.response.ParameterListDTO;

public interface ParameterService {
    ParameterDTO getParameter(Long parameterId);

    ParameterListDTO getAllParameters();

    ParameterDTO addParameter(ParameterRequestDTO requestDTO);

    ParameterDTO editParameter(Long parameterId, ParameterRequestDTO requestDTO);

    void deleteParameter(Long parameterId);
}
