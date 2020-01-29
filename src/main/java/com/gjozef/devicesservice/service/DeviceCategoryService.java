package com.gjozef.devicesservice.service;

import com.gjozef.devicesservice.dto.response.DeviceCategoryDTO;
import com.gjozef.devicesservice.dto.response.DeviceCategoryListDTO;

public interface DeviceCategoryService {
    DeviceCategoryDTO getCategory(Long deviceId);

    DeviceCategoryListDTO getAllCategories();

    DeviceCategoryDTO addCategory(DeviceCategoryDTO requestDTO);

    DeviceCategoryDTO editCategory(Long deviceId, DeviceCategoryDTO requestDTO);

    void deleteCategory(Long categoryId);
}
