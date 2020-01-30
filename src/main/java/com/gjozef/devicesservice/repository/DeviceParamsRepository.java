package com.gjozef.devicesservice.repository;

import com.gjozef.devicesservice.domain.DeviceParams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceParamsRepository extends JpaRepository<DeviceParams, Long> {
}
