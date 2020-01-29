package com.gjozef.devicesservice.service.impl;

import com.gjozef.devicesservice.assembler.DeviceCategoryDTOAssembler;
import com.gjozef.devicesservice.domain.DeviceCategory;
import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import com.gjozef.devicesservice.dto.response.DeviceCategoryListDTO;
import com.gjozef.devicesservice.exceptions.ResourceAlreadyExistsException;
import com.gjozef.devicesservice.exceptions.ResourceNotFoundException;
import com.gjozef.devicesservice.repository.DeviceCategoryRepository;
import com.gjozef.devicesservice.service.DeviceCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeviceCategoryServiceImpl implements DeviceCategoryService {

    private final DeviceCategoryRepository categoryRepository;
    private final DeviceCategoryDTOAssembler categoryDTOAssembler;

    @Override
    public DeviceCategoryDTO getCategory(Long categoryId) {
        log.info("getCategory() id={}", categoryId);
        DeviceCategory deviceCategory = fetchCategory(categoryId);
        return categoryDTOAssembler.fromDomain(deviceCategory);
    }

    @Override
    public DeviceCategoryListDTO getAllCategories() {
        log.info("getAllCategories()");
        List<DeviceCategory> deviceCategories = categoryRepository.findAllByActiveTrue();
        if (CollectionUtils.isNotEmpty(deviceCategories)) {
            return new DeviceCategoryListDTO(deviceCategories.stream()
                .map(categoryDTOAssembler::fromDomain)
                .collect(Collectors.toList()));
        }
        return new DeviceCategoryListDTO();
    }

    @Override
    public DeviceCategoryDTO addCategory(DeviceCategoryDTO requestDTO) {
        log.info("addCategory() using request={}", requestDTO);
        if (categoryRepository.existsByNameAndActiveTrue(requestDTO.getName())) {
            throw new ResourceAlreadyExistsException(DeviceCategory.class, "name", requestDTO.getName());
        }
        DeviceCategory deviceCategory = categoryDTOAssembler.toDomain(requestDTO);
        return categoryDTOAssembler.fromDomain(categoryRepository.save(deviceCategory));
    }

    @Override
    public DeviceCategoryDTO editCategory(Long categoryId, DeviceCategoryDTO requestDTO) {
        log.info("editCategory() id={}", categoryId);
        if (categoryRepository.existsByNameAndIdIsNotAndActiveTrue(requestDTO.getName(), categoryId)) {
            throw new ResourceAlreadyExistsException(DeviceCategory.class, "name", requestDTO.getName());
        }
        DeviceCategory deviceCategory = fetchCategory(categoryId);
        categoryDTOAssembler.fillInDomain(requestDTO, deviceCategory);
        return categoryDTOAssembler.fromDomain(categoryRepository.save(deviceCategory));
    }

    @Override
    public void deleteCategory(Long categoryId) {
        log.info("deleteCategory() id={}", categoryId);
        DeviceCategory deviceCategory = fetchCategory(categoryId);
        deviceCategory.setActive(false);
        categoryRepository.save(deviceCategory);
    }

    private DeviceCategory fetchCategory(Long categoryId) {
        return categoryRepository.findById(categoryId)
            .orElseThrow(() -> new ResourceNotFoundException(DeviceCategory.class, "id", categoryId.toString()));
    }
}
