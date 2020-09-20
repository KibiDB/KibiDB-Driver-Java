package com.kibi.driver.exception;

public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String address, int port) {
        super("Error when trying to connect to KibiDB Server in (" + address + ") (" + port + ") login failed [Wrong password]");
    }
}
