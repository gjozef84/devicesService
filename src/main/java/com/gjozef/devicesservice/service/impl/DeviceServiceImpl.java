package com.gjozef.devicesservice.service.impl;

import com.gjozef.devicesservice.assembler.DeviceDTOAssembler;
import com.gjozef.devicesservice.assembler.DeviceRequestDTOAssembler;
import com.gjozef.devicesservice.domain.Device;
import com.gjozef.devicesservice.dto.request.DeviceRequestDTO;
import com.gjozef.devicesservice.dto.response.DeviceDTO;
import com.gjozef.devicesservice.dto.response.DeviceListDTO;
import com.gjozef.devicesservice.exceptions.ResourceNotFoundException;
import com.gjozef.devicesservice.repository.DeviceRepository;
import com.gjozef.devicesservice.service.DeviceService;
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
    private final DeviceRequestDTOAssembler deviceRequestDTOAssembler;

    @Override
    public DeviceDTO getDevice(Long deviceId) {
        log.info("getDevice() for id={}", deviceId);
        Device device = fetchDevice(deviceId);
        return deviceDTOAssembler.fromDomain(device);
    }

    @Override
    public DeviceListDTO getAllDevices() {
        log.info("getAllDevices()");
        List<Device> allDevices = deviceRepository.findAllByActiveTrue();
        if (CollectionUtils.isNotEmpty(allDevices)) {
            return getDeviceListDTOByDevice(allDevices);
        }
        //todo jak starczy czasu to przerobię na stronnicowaną i filtrowaną specyfikacją listę
        return new DeviceListDTO();
    }

    @Override
    public DeviceDTO addDevice(DeviceRequestDTO deviceRequestDTO) {
        log.info("addDevice() using requestDTO={}", deviceRequestDTO);
        Device device = new Device();
        deviceRequestDTOAssembler.fillInDomain(deviceRequestDTO, device);
        return deviceDTOAssembler.fromDomain(deviceRepository.save(device));
    }

    @Override
    public DeviceDTO editDevice(Long deviceId, DeviceRequestDTO deviceRequestDTO) {
        log.info("editDevice() id={} using requestDTO={}", deviceId, deviceRequestDTO);
        Device device = fetchDevice(deviceId);
        deviceRequestDTOAssembler.fillInDomain(deviceRequestDTO, device);
        return deviceDTOAssembler.fromDomain(deviceRepository.save(device));
    }

    @Override
    public void deleteDevice(Long deviceId) {
        log.info("deleteDevice() id={}", deviceId);
        Device device = fetchDevice(deviceId);
        device.setActive(false);
        deviceRepository.save(device);
    }

    private DeviceListDTO getDeviceListDTOByDevice(List<Device> allDevices) {
        List<DeviceDTO> devices = allDevices.stream()
            .map(deviceDTOAssembler::fromDomain)
            .collect(Collectors.toList());

        return new DeviceListDTO(devices);
    }

    private Device fetchDevice(Long deviceId) {
        return deviceRepository.findById(deviceId)
            .orElseThrow(() -> new ResourceNotFoundException(Device.class, "id", deviceId.toString()));
    }
}
