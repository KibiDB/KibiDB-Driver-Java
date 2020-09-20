package com.kibi.driver;

public class Client {
    private final String address;
    private final int port;
    private final String password;
    private final Connection connection;

    public Client(String address, int port, String password) {
        this.address = address;
        this.port = port;
        this.password = password;
        this.connection = new Connection(this);
    }

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
        this.password = "none";
        this.connection = new Connection(this);
    }

    public Client(String password) {
        this.address = "127.0.0.1";
        this.port = 3306;
        this.password = password;
        this.connection = new Connection(this);
    }

    public Client(int port) {
        this.address = "127.0.0.1";
        this.port = port;
        this.password = "none";
        this.connection = new Connection(this);
    }

    public Client() {
        this.address = "127.0.0.1";
        this.port = 3306;
        this.password = "none";
        this.connection = new Connection(this);
    }

    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnection() {
        return connection;
    }
}
