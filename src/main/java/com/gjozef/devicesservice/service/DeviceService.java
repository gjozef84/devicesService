package com.gjozef.devicesservice.service;

import com.gjozef.devicesservice.domain.Device;
import com.gjozef.devicesservice.domain.DeviceStatus;
import com.gjozef.devicesservice.dto.request.DeviceRequestDTO;
import com.gjozef.devicesservice.dto.response.DeviceDTO;
import com.gjozef.devicesservice.dto.response.DeviceListDTO;
import com.gjozef.devicesservice.exceptions.ResourceNotFoundException;

public interface DeviceService {

    DeviceDTO getDevice(Long deviceId) throws ResourceNotFoundException;

    DeviceListDTO getAllDevices();

    void deleteDevice(Long deviceId);

    DeviceDTO addDevice(DeviceRequestDTO deviceRequestDTO);

    DeviceDTO editDevice(Long deviceId, DeviceRequestDTO deviceRequestDTO);

    Device fetchDevice(Long deviceId);

    DeviceDTO changeStatus(Long deviceId, DeviceStatus deviceStatus);
}
