package com.gjozef.devicesservice.service.impl;

import com.gjozef.devicesservice.assembler.ParameterDTOAssembler;
import com.gjozef.devicesservice.assembler.ParameterRequestDTOAssembler;
import com.gjozef.devicesservice.domain.Parameter;
import com.gjozef.devicesservice.dto.request.ParameterRequestDTO;
import com.gjozef.devicesservice.dto.response.ParameterDTO;
import com.gjozef.devicesservice.dto.response.ParameterListDTO;
import com.gjozef.devicesservice.exceptions.ResourceNotFoundException;
import com.gjozef.devicesservice.repository.ParameterRepository;
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
public class ParameterServiceImpl implements ParameterService {

    private final ParameterRepository parameterRepository;
    private final ParameterDTOAssembler parameterDTOAssembler;
    private final ParameterRequestDTOAssembler parameterRequestDTOAssembler;

    @Override
    public ParameterDTO getParameter(Long parameterId) {
        log.info("getParameter() id={}", parameterId);
        Parameter parameter = fetchParameter(parameterId);
        return parameterDTOAssembler.fromDomain(parameter);
    }

    @Override
    public ParameterListDTO getAllParameters() {
        log.info("getAllParameters()");
        List<Parameter> parameters = parameterRepository.findAllByActiveTrue();
        if (CollectionUtils.isNotEmpty(parameters)) {
            return new ParameterListDTO(parameters.stream()
                .map(parameterDTOAssembler::fromDomain)
                .collect(Collectors.toList()));
        }
        return new ParameterListDTO();
    }

    @Override
    public ParameterDTO addParameter(ParameterRequestDTO requestDTO) {
        log.info("addParameter() using requestDTO={}", requestDTO);
        Parameter parameter = new Parameter();
        parameterRequestDTOAssembler.fillInDomain(requestDTO, parameter);

        return parameterDTOAssembler.fromDomain(parameterRepository.save(parameter));
    }

    @Override
    public ParameterDTO editParameter(Long parameterId, ParameterRequestDTO requestDTO) {
        log.info("editParameter() using requestDTO={}", requestDTO);
        Parameter parameter = fetchParameter(parameterId);
        parameterRequestDTOAssembler.fillInDomain(requestDTO, parameter);

        return parameterDTOAssembler.fromDomain(parameterRepository.save(parameter));
    }

    @Override
    public void deleteParameter(Long parameterId) {
        log.info("deleteParameter() is={}", parameterId);
        Parameter parameter = fetchParameter(parameterId);
        parameter.setActive(false);
        parameterRepository.save(parameter);
    }

    private Parameter fetchParameter(Long parameterId) {
        return parameterRepository.findByIdAndActiveTrue(parameterId)
            .orElseThrow(() -> new ResourceNotFoundException(Parameter.class, "id", parameterId.toString()));
    }
}
