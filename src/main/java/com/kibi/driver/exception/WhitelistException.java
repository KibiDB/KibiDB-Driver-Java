package com.kibi.driver.exception;

public class WhitelistException extends Exception {
    public WhitelistException(String address, int port) {
        super("Error when trying to connect to KibiDB Server in (" + address + ") (" + port + ") request denied [KibiDB in whitelisted]");
    }
}
