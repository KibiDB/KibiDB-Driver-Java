package com.kibi.driver.exception;

public class ShutdownException extends Exception {
    public ShutdownException() {
        super("KibiDB Server interrupted the connection [FORCE SHUTDOWN]");
    }
}
