package com.gjozef.devicesservice.service.impl;

import com.gjozef.devicesservice.assembler.DeviceParamsDTOAssembler;
import com.gjozef.devicesservice.domain.Device;
import com.gjozef.devicesservice.domain.DeviceParams;
import com.gjozef.devicesservice.domain.Parameter;
import com.gjozef.devicesservice.dto.request.ParameterValueRequestDTO;
import com.gjozef.devicesservice.dto.response.DeviceParamsDTO;
import com.gjozef.devicesservice.dto.response.DeviceParamsListDTO;
import com.gjozef.devicesservice.exceptions.ResourceAlreadyExistsException;
import com.gjozef.devicesservice.repository.DeviceParamsRepository;
import com.gjozef.devicesservice.service.DeviceParamService;
import com.gjozef.devicesservice.service.DeviceService;
import com.gjozef.devicesservice.service.ParameterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeviceParamServiceImpl implements DeviceParamService {

    private final DeviceParamsRepository deviceParamsRepository;
    private final DeviceParamsDTOAssembler deviceParamsDTOAssembler;
    private final DeviceService deviceService;
    private final ParameterService parameterService;

    @Override
    public DeviceParamsDTO addParamToDevice(Long deviceId, Long paramId, ParameterValueRequestDTO paramValueRequest) {
        if (deviceParamsRepository.existsByDeviceIdAndParameterIdAndActiveTrue(deviceId, paramId)) {
            throw new ResourceAlreadyExistsException(DeviceParams.class, "deviceId/parameterId", deviceId.toString() + "/" + paramId.toString());
        }
        DeviceParams deviceParam = new DeviceParams();
        Device device = deviceService.fetchDevice(deviceId);
        Parameter parameter = parameterService.fetchParameter(paramId);
        deviceParam.setDevice(device);
        deviceParam.setParameter(parameter);
        deviceParam.setValue(paramValueRequest.getValue());
        return deviceParamsDTOAssembler.fromDomain(deviceParamsRepository.save(deviceParam));
    }

    @Override
    public DeviceParamsListDTO getAllDeviceParams(Long deviceId) {
        log.info("getAllDeviceParams() deviceId={}", deviceId);
        List<DeviceParams> deviceParams = deviceParamsRepository.findAllByDeviceIdAndActiveTrue(deviceId);
        if (CollectionUtils.isNotEmpty(deviceParams)) {
            return new DeviceParamsListDTO(
                deviceParams.stream()
                    .map(deviceParamsDTOAssembler::fromDomain)
                    .collect(Collectors.toList())
            );
        }
        return new DeviceParamsListDTO();
    }
}
