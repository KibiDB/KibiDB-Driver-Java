package com.kibi.driver;

public class Client {
    private final String address;
    private final int port;
    private final String password;

    public Client(String address, int port, String password) {
        this.address = address;
        this.port = port;
        this.password = password;
    }

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
        this.password = "none";
    }

    public Client(String address) {
        this.address = address;
        this.port = 3306;
        this.password = "none";
    }

    public Client() {
        this.address = "127.0.0.1";
        this.port = 3306;
        this.password = "none";
    }
}
