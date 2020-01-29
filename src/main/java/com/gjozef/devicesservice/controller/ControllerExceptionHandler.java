package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.dto.response.ResourceNotFoundDTO;
import com.gjozef.devicesservice.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ResourceNotFoundDTO> resourceNotFoundExceptionHandler(ResourceNotFoundException rnfe) {
        log.error(rnfe.getMessage(), rnfe);
        ResourceNotFoundDTO dto = new ResourceNotFoundDTO(rnfe.getObjectName(), rnfe.getPropertyName(), rnfe.getPropertyValue());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}