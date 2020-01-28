package com.gjozef.devicesService.service;

import com.gjozef.devicesService.dto.response.DeviceDTO;
import com.gjozef.devicesService.dto.response.DeviceListDTO;
import com.gjozef.devicesService.exceptions.ResourceNotFoundException;

public interface DeviceService {

    DeviceDTO getDevice(Long deviceId) throws ResourceNotFoundException;

    DeviceListDTO getAllDevices();
}
