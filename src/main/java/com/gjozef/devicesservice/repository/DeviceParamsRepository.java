package com.gjozef.devicesservice.repository;

import com.gjozef.devicesservice.domain.DeviceParams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceParamsRepository extends JpaRepository<DeviceParams, Long> {

    List<DeviceParams> findAllByDeviceIdAndActiveTrue(Long deviceId);

    boolean existsByDeviceIdAndParameterIdAndActiveTrue(Long deviceId, Long paramId);
}
