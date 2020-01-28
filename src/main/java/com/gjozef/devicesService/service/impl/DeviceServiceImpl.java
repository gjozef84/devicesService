package com.gjozef.devicesService.service.impl;

import com.gjozef.devicesService.assembler.DeviceDTOAssembler;
import com.gjozef.devicesService.domain.Device;
import com.gjozef.devicesService.dto.response.DeviceDTO;
import com.gjozef.devicesService.dto.response.DeviceListDTO;
import com.gjozef.devicesService.exceptions.ResourceNotFoundException;
import com.gjozef.devicesService.repository.DeviceRepository;
import com.gjozef.devicesService.service.DeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceDTOAssembler deviceDTOAssembler;

    @Override
    public DeviceDTO getDevice(Long deviceId) {
        log.info("getDevice() for id={}", deviceId);
        Device device = deviceRepository.findById(deviceId)
            .orElseThrow(() -> new ResourceNotFoundException(Device.class, "id", deviceId.toString()));
        return deviceDTOAssembler.fromDomain(device);
    }

    @Override
    public DeviceListDTO getAllDevices() {
        log.info("getAllDevices()");
        List<Device> allDevices = deviceRepository.findAllByActiveTrue();
        if (CollectionUtils.isNotEmpty(allDevices)) {
            return getDeviceListDTOByDevice(allDevices);
        }
        return new DeviceListDTO();
    }

    private DeviceListDTO getDeviceListDTOByDevice(List<Device> allDevices) {
        List<DeviceDTO> devices = allDevices.stream()
            .map(deviceDTOAssembler::fromDomain)
            .collect(Collectors.toList());

        return new DeviceListDTO(devices);
    }
}
