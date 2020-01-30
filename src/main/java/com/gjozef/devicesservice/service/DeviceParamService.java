package com.gjozef.devicesservice.service;

import com.gjozef.devicesservice.dto.request.ParameterValueRequestDTO;
import com.gjozef.devicesservice.dto.response.DeviceParamsDTO;
import com.gjozef.devicesservice.dto.response.DeviceParamsListDTO;

public interface DeviceParamService {
    DeviceParamsDTO addParamToDevice(Long deviceId, Long paramId, ParameterValueRequestDTO paramValueRequest);

    DeviceParamsListDTO getAllDeviceParams(Long deviceId);
}
