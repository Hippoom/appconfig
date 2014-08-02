package com.github.hippoom.appconfig.sampleapp;

public class IncompatibleConfigurationVersionException extends RuntimeException {
    public IncompatibleConfigurationVersionException(String message) {
        super(message);
    }
}
