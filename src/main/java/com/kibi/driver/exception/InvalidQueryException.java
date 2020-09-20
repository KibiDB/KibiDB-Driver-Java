package com.kibi.driver.exception;

public class InvalidQueryException extends Exception {
    public InvalidQueryException(String query) {
        super("Invalid Query [" + query + "]");
    }
}
