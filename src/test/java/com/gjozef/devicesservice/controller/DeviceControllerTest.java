package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.domain.DeviceStatus;
import com.gjozef.devicesservice.dto.request.DeviceRequestDTO;
import com.gjozef.devicesservice.dto.request.ParameterValueRequestDTO;
import com.gjozef.devicesservice.dto.response.DeviceDTO;
import com.gjozef.devicesservice.dto.response.DeviceListDTO;
import com.gjozef.devicesservice.dto.response.DeviceParamsDTO;
import com.gjozef.devicesservice.dto.response.DeviceParamsListDTO;
import com.gjozef.devicesservice.service.DeviceParamService;
import com.gjozef.devicesservice.service.DeviceService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DeviceControllerTest {

    @Mock
    private DeviceService deviceService;
    @Mock
    private DeviceParamService deviceParamService;

    private DeviceController deviceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        deviceController = new DeviceController(deviceService, deviceParamService);
    }

    @Test
    public void testGetDevice() {
        Long deviceId = RandomUtils.nextLong();
        DeviceDTO result = mock(DeviceDTO.class);
        when(deviceService.getDevice(deviceId)).thenReturn(result);

        ResponseEntity<DeviceDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        ResponseEntity<DeviceDTO> actual = deviceController.getDevice(deviceId);

        assertEquals(expected, actual);
        verify(deviceService).getDevice(anyLong());
    }

    @Test
    public void testGetAllDevices() {
        DeviceListDTO result = mock(DeviceListDTO.class);
        when(deviceService.getAllDevices()).thenReturn(result);

        ResponseEntity<DeviceListDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        ResponseEntity<DeviceListDTO> actual = deviceController.getAllDevices();

        assertEquals(expected, actual);
        verify(deviceService).getAllDevices();
    }

    @Test
    public void testAddDevice() {
        DeviceRequestDTO deviceRequestDTO = mock(DeviceRequestDTO.class);
        DeviceDTO result = mock(DeviceDTO.class);
        when(deviceService.addDevice(deviceRequestDTO)).thenReturn(result);

        ResponseEntity<DeviceDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        ResponseEntity<DeviceDTO> actual = deviceController.addDevice(deviceRequestDTO);

        assertEquals(expected, actual);
        verify(deviceService).addDevice(any(DeviceRequestDTO.class));
    }

    @Test
    public void testEditDevice() {
        Long deviceId = RandomUtils.nextLong();
        DeviceRequestDTO deviceRequestDTO = mock(DeviceRequestDTO.class);
        DeviceDTO result = mock(DeviceDTO.class);
        when(deviceService.editDevice(deviceId, deviceRequestDTO)).thenReturn(result);

        ResponseEntity<DeviceDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        ResponseEntity<DeviceDTO> actual = deviceController.editDevice(deviceId, deviceRequestDTO);

        assertEquals(expected, actual);
        verify(deviceService).editDevice(anyLong(), any(DeviceRequestDTO.class));
    }

    @Test
    public void testDeleteDevice() {
        Long deviceId = RandomUtils.nextLong();

        ResponseEntity<Void> expected = new ResponseEntity<>(HttpStatus.OK);
        ResponseEntity<Void> actual = deviceController.deleteDevice(deviceId);

        assertEquals(expected, actual);
        verify(deviceService).deleteDevice(anyLong());
    }

    @Test
    public void testAddParamToDevice() {
        Long deviceId = RandomUtils.nextLong();
        Long paramId = RandomUtils.nextLong();
        ParameterValueRequestDTO paramValueRequest = mock(ParameterValueRequestDTO.class);
        DeviceParamsDTO result = mock(DeviceParamsDTO.class);
        when(deviceParamService.addParamToDevice(deviceId, paramId, paramValueRequest)).thenReturn(result);

        ResponseEntity<DeviceParamsDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        ResponseEntity<DeviceParamsDTO> actual = deviceController.addParamToDevice(deviceId, paramId, paramValueRequest);

        assertEquals(expected, actual);
        verify(deviceParamService).addParamToDevice(anyLong(), anyLong(), any(ParameterValueRequestDTO.class));
    }

    @Test
    public void testGetAllDeviceParams() {
        Long deviceId = RandomUtils.nextLong();
        DeviceParamsListDTO result = mock(DeviceParamsListDTO.class);
        when(deviceParamService.getAllDeviceParams(deviceId)).thenReturn(result);

        ResponseEntity<DeviceParamsListDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        ResponseEntity<DeviceParamsListDTO> actual = deviceController.getAllDeviceParams(deviceId);

        assertEquals(expected, actual);
        verify(deviceParamService).getAllDeviceParams(anyLong());
    }

    @Test
    public void testChangeDeviceStatus() {
        Long deviceId = RandomUtils.nextLong();
        DeviceStatus deviceStatus = DeviceStatus.SPRAWNY;
        DeviceDTO result = mock(DeviceDTO.class);
        when(deviceService.changeStatus(deviceId, deviceStatus)).thenReturn(result);

        ResponseEntity<DeviceDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        ResponseEntity<DeviceDTO> actual = deviceController.changeDeviceStatus(deviceId, deviceStatus);

        assertEquals(expected, actual);
        verify(deviceService).changeStatus(anyLong(), any(DeviceStatus.class));
    }
}