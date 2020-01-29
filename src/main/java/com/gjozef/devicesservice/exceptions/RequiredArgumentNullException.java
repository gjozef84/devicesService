package com.gjozef.devicesservice.exceptions;

public class RequiredArgumentNullException extends RuntimeException {

    private String argument;

    public RequiredArgumentNullException(String argument) {
        super(String.format("Required Argument %s Is Null", argument));
    }
}
