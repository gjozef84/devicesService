package com.gjozef.devicesService.assembler;

import com.gjozef.devicesService.domain.AbstractDeviceServiceEntity;
import com.gjozef.devicesService.dto.AbstractDTO;
import org.springframework.lang.NonNull;

/**
 * Converts domain objects of type T to DTOs of type S.
 *
 * @param <T> The type of domain objects
 * @param <S> The type of DTO objects
 */
public interface DomainToDTOAssembler<T extends AbstractDeviceServiceEntity, S extends AbstractDTO> {

    /**
     * Converts domain object to a new DTO.
     */
    S fromDomain(@NonNull T domain);
}
