package com.gjozef.devicesservice.repository;

import com.gjozef.devicesservice.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findAllByActiveTrue();

    Optional<Device> findByIdAndActiveTrue(Long deviceId);
}
