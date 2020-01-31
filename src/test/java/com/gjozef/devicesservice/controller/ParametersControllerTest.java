package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.dto.request.ParameterRequestDTO;
import com.gjozef.devicesservice.dto.response.ParameterDTO;
import com.gjozef.devicesservice.dto.response.ParameterListDTO;
import com.gjozef.devicesservice.service.ParameterService;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParametersControllerTest {

    @Mock
    private ParameterService parameterService;

    private ParametersController parametersController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        parametersController = new ParametersController(parameterService);
    }

    @Test
    public void testGetParameter() {
        Long parameterId = RandomUtils.nextLong();
        ParameterDTO result = mock(ParameterDTO.class);
        when(parameterService.getParameter(parameterId)).thenReturn(result);

        final ResponseEntity<ParameterDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<ParameterDTO> actual = parametersController.getParameter(parameterId);

        assertEquals(expected, actual);
        verify(parameterService).getParameter(anyLong());
    }

    @Test
    public void testGetAllParameters() {
        ParameterListDTO result = mock(ParameterListDTO.class);
        when(parameterService.getAllParameters()).thenReturn(result);

        final ResponseEntity<ParameterListDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<ParameterListDTO> actual = parametersController.getAllParameters();

        assertEquals(expected, actual);
        verify(parameterService).getAllParameters();
    }

    @Test
    public void testAddParameter() {
        ParameterDTO result = mock(ParameterDTO.class);
        ParameterRequestDTO requestDTO = mock(ParameterRequestDTO.class);
        when(parameterService.addParameter(requestDTO)).thenReturn(result);

        final ResponseEntity<ParameterDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<ParameterDTO> actual = parametersController.addParameter(requestDTO);

        assertEquals(expected, actual);
        verify(parameterService).addParameter(any(ParameterRequestDTO.class));
    }

    @Test
    public void testEditParameter() {
        Long parameterId = RandomUtils.nextLong();
        ParameterDTO result = mock(ParameterDTO.class);
        ParameterRequestDTO requestDTO = mock(ParameterRequestDTO.class);
        when(parameterService.editParameter(parameterId, requestDTO)).thenReturn(result);

        final ResponseEntity<ParameterDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<ParameterDTO> actual = parametersController.editParameter(parameterId, requestDTO);

        assertEquals(expected, actual);
        verify(parameterService).editParameter(anyLong(), any(ParameterRequestDTO.class));
    }

    @Test
    public void testDeleteParameter() {
        Long parameterId = RandomUtils.nextLong();
        doNothing().when(parameterService).deleteParameter(parameterId);

        final ResponseEntity<Void> expected = new ResponseEntity<>(HttpStatus.OK);
        final ResponseEntity<Void> actual = parametersController.deleteParameter(parameterId);

        assertEquals(expected, actual);
        verify(parameterService).deleteParameter(anyLong());
    }
}