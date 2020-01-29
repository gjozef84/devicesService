package com.gjozef.devicesservice.repository;

import com.gjozef.devicesservice.domain.DeviceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceCategoryRepository extends JpaRepository<DeviceCategory, Long> {
    boolean existsByNameAndIdIsNotAndActiveTrue(String name, Long categoryId);

    boolean existsByNameAndActiveTrue(String name);

    List<DeviceCategory> findAllByActiveTrue();
}
