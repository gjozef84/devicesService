package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.dto.response.ResourceExceptionDTO;
import com.gjozef.devicesservice.exceptions.ResourceAlreadyExistsException;
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
    public ResponseEntity<ResourceExceptionDTO> resourceNotFoundExceptionHandler(ResourceNotFoundException rnfe) {
        log.error(rnfe.getMessage(), rnfe);
        ResourceExceptionDTO dto = new ResourceExceptionDTO(rnfe.getObjectName(), rnfe.getPropertyName(), rnfe.getPropertyValue());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ResourceAlreadyExistsException.class})
    public ResponseEntity<ResourceExceptionDTO> applicationExceptionHandler(ResourceAlreadyExistsException raee) {
        log.error(raee.getMessage(), raee);
        ResourceExceptionDTO dto = new ResourceExceptionDTO(raee.getObjectName(), raee.getPropertyName(), raee.getPropertyValue());
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}