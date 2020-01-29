package com.gjozef.devicesservice.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

    private final String objectName;
    private final String propertyName;
    private final String propertyValue;

    public ResourceNotFoundException(final Class objectClass, final String propertyName, final String propertyValue) {
        super(String.format("RESOURCE %s NOT_FOUND, for %s = %s", objectClass.getSimpleName(), propertyName, propertyValue));
        this.objectName = objectClass.getSimpleName();
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
    }
}
