package com.gjozef.devicesservice.service;

import com.gjozef.devicesservice.dto.response.DeviceDTO;
import com.gjozef.devicesservice.dto.response.DeviceListDTO;
import com.gjozef.devicesservice.exceptions.ResourceNotFoundException;

public interface DeviceService {

    DeviceDTO getDevice(Long deviceId) throws ResourceNotFoundException;

    DeviceListDTO getAllDevices();
}
