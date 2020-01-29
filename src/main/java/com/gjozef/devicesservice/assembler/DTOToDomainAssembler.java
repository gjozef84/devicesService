package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.AbstractDeviceServiceEntity;
import com.gjozef.devicesservice.dto.AbstractDTO;
import org.springframework.lang.NonNull;

public interface DTOToDomainAssembler<T extends AbstractDeviceServiceEntity, S extends AbstractDTO> {

    /**
     * Converts DTO to a new domain object.
     */
    T toDomain(@NonNull S dto);

    /**
     * Fills-in domain object with values from DTO (recursively, if needed). Any already filled-in values will be replaced
     * (possibly with nulls).
     */
    void fillInDomain(S dto, T domain);
}
