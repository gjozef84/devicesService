package com.gjozef.devicesservice.assembler;

import com.gjozef.devicesservice.domain.AbstractDeviceServiceEntity;
import com.gjozef.devicesservice.dto.AbstractDTO;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

public abstract class AbstractDomainToDTOAssembler<T extends AbstractDeviceServiceEntity, S extends AbstractDTO>
    implements DomainToDTOAssembler<T, S> {

    @Override
    public final S fromDomain(@NonNull T domain) {
        Assert.notNull(domain, "Domain object cannot be null");

        S dto = createEmptyDto();
        fillInDto(domain, dto);

        return dto;
    }

    /**
     * Fills-in DTO with values from domain object. Any already filled-in values will be replaced (possibly with nulls).
     */
    protected abstract void fillInDto(T domain, S dto);

    /**
     * Creates an empty instance of DTO that will be used later by fillInDto() method.
     */
    protected abstract S createEmptyDto();
}