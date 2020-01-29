package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.controller.swagger.DeviceServiceControllerSwagger;
import com.gjozef.devicesservice.dto.response.DeviceDTO;
import com.gjozef.devicesservice.dto.response.DeviceListDTO;
import com.gjozef.devicesservice.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/device")
@RequiredArgsConstructor
public class DeviceServiceController implements DeviceServiceControllerSwagger {

    private final DeviceService deviceService;

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
}
