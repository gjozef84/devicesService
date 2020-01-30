package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.controller.swagger.DeviceControllerSwagger;
import com.gjozef.devicesservice.domain.DeviceStatus;
import com.gjozef.devicesservice.dto.request.DeviceRequestDTO;
import com.gjozef.devicesservice.dto.request.ParameterValueRequestDTO;
import com.gjozef.devicesservice.dto.response.DeviceDTO;
import com.gjozef.devicesservice.dto.response.DeviceListDTO;
import com.gjozef.devicesservice.dto.response.DeviceParamsDTO;
import com.gjozef.devicesservice.dto.response.DeviceParamsListDTO;
import com.gjozef.devicesservice.service.DeviceParamService;
import com.gjozef.devicesservice.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/device")
@RequiredArgsConstructor
public class DeviceController implements DeviceControllerSwagger {

    private final DeviceService deviceService;
    private final DeviceParamService deviceParamService;

    @Override
    @GetMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDTO> getDevice(@PathVariable(name = "deviceId") Long deviceId) {
        return new ResponseEntity<>(deviceService.getDevice(deviceId), HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/all")
    public ResponseEntity<DeviceListDTO> getAllDevices() {
        return new ResponseEntity<>(deviceService.getAllDevices(), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<DeviceDTO> addDevice(@RequestBody @Valid DeviceRequestDTO deviceRequestDTO) {
        return new ResponseEntity<>(deviceService.addDevice(deviceRequestDTO), HttpStatus.OK);
    }

    @Override
    @PutMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDTO> editDevice(@PathVariable(name = "deviceId") Long deviceId, @RequestBody @Valid DeviceRequestDTO deviceRequestDTO) {
        return new ResponseEntity<>(deviceService.editDevice(deviceId, deviceRequestDTO), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "deviceId")
    public ResponseEntity<Void> deleteDevice(@PathVariable(name = "deviceId") Long deviceId) {
        deviceService.deleteDevice(deviceId);
        return ResponseEntity.ok().build();
    }

    @Override
    @PostMapping("/{deviceId}/param/{paramId}")
    public ResponseEntity<DeviceParamsDTO> addParamToDevice(@PathVariable(name = "deviceId") Long deviceId, @PathVariable(name = "paramId") Long paramId,
                                                            @RequestBody @Valid ParameterValueRequestDTO paramValueRequest) {
        return new ResponseEntity<DeviceParamsDTO>(deviceParamService.addParamToDevice(deviceId, paramId, paramValueRequest), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{deviceId}/param/all")
    public ResponseEntity<DeviceParamsListDTO> getAllDeviceParams(@PathVariable(name = "deviceId") Long deviceId) {
        return new ResponseEntity<DeviceParamsListDTO>(deviceParamService.getAllDeviceParams(deviceId), HttpStatus.OK);
    }

    @Override
    @PostMapping("/{deviceId}/status")
    public ResponseEntity<DeviceDTO> changeDeviceStatus(@PathVariable(name = "deviceId") Long deviceId, @NotNull DeviceStatus deviceStatus) {
        return new ResponseEntity<>(deviceService.changeStatus(deviceId, deviceStatus), HttpStatus.OK);
    }
}
