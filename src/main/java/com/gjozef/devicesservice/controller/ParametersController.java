package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.controller.swagger.ParametersControllerSwagger;
import com.gjozef.devicesservice.dto.request.ParameterRequestDTO;
import com.gjozef.devicesservice.dto.response.ParameterDTO;
import com.gjozef.devicesservice.dto.response.ParameterListDTO;
import com.gjozef.devicesservice.service.ParameterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@RestController
@RequestMapping("/api/parameters")
@RequiredArgsConstructor
@Slf4j
public class ParametersController implements ParametersControllerSwagger {

    private final ParameterService parameterService;

    @Override
    @GetMapping(value = "/{parameterId}")
    public ResponseEntity<ParameterDTO> getParameter(@PathVariable(name = "parameterId") Long parameterId) {
        return new ResponseEntity<>(parameterService.getParameter(parameterId), HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/all")
    public ResponseEntity<ParameterListDTO> getAllParameters() {
        return new ResponseEntity<>(parameterService.getAllParameters(), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<ParameterDTO> addParameter(@RequestBody @Valid ParameterRequestDTO requestDTO) {
        return new ResponseEntity<>(parameterService.addParameter(requestDTO), HttpStatus.OK);
    }

    @Override
    @PutMapping(value = "/parameterId")
    public ResponseEntity<ParameterDTO> editParameter(@PathVariable(name = "parameterId") Long parameterId, @RequestBody @Valid ParameterRequestDTO requestDTO) {
        return new ResponseEntity<>(parameterService.editParameter(parameterId, requestDTO), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/parameterId")
    public ResponseEntity<Void> deleteParameter(@PathVariable(name = "parameterId") Long parameterId) {
        parameterService.deleteParameter(parameterId);
        return ResponseEntity.ok().build();
    }
}
