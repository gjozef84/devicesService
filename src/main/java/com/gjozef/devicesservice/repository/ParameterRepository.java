package com.gjozef.devicesservice.repository;

import com.gjozef.devicesservice.domain.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {
    Optional<Parameter> findByIdAndActiveTrue(Long parameterId);

    List<Parameter> findAllByActiveTrue();

    boolean existsByNameAndActiveTrue(String name);

    boolean existsByNameAndIdIsNotAndActiveTrue(String name, Long id);
}
