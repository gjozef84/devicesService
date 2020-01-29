package com.gjozef.devicesservice.exceptions;

import lombok.Data;

@Data
public class ResourceAlreadyExistsException extends RuntimeException {

    private final String objectName;
    private final String propertyName;
    private final String propertyValue;

    public ResourceAlreadyExistsException(final Class objectClass, final String propertyName, final String propertyValue) {
        super(String.format("RESOURCE %s ALREADY EXISTS, %s = %s", objectClass.getSimpleName(), propertyName, propertyValue));
        this.objectName = objectClass.getSimpleName();
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
    }
}
