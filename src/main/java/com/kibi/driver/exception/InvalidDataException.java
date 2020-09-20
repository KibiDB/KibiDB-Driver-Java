package com.kibi.driver.exception;

public class InvalidDataException extends Exception {
    public InvalidDataException(String data) {
        super("Invalid Data [" + data + "]");
    }
}
