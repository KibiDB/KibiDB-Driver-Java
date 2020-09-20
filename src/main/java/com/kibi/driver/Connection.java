package com.kibi.driver;

import com.kibi.driver.exception.*;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {
    private final Client client;

    public Connection(Client client) {
        this.client = client;
    }

    private String execute(String query) {
        String execute = client.getPassword() + " " + query;
        String address = client.getAddress();
        int port = client.getPort();

        try {
            Socket server = new Socket(address, port);

            OutputStream outToServer = server.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF(execute);

            InputStream inFromServer = server.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            String reply = in.readUTF();

            if (reply.equals("IN WHITELIST")) {

                try {
                    throw new WhitelistException(address, port);
                } catch (WhitelistException e) {
                    e.printStackTrace();
                }

                out.close();
                server.close();
                return null;
            }

            if (reply.equals("LOGIN FAILED")) {
                try {
                    throw new IncorrectPasswordException(address, port);
                } catch (IncorrectPasswordException e) {
                    e.printStackTrace();
                }

                out.close();
                server.close();
                return null;
            }

            if (reply.equals("INVALID QUERY")) {
                try {
                    throw new InvalidQueryException(query);
                } catch (InvalidQueryException e) {
                    e.printStackTrace();
                }

                out.close();
                server.close();
                return null;
            }

            if (reply.equals("FORCE SHUTDOWN")) {
                try {
                    throw new ShutdownException();
                } catch (ShutdownException e) {
                    e.printStackTrace();
                }
            }

            out.close();
            server.close();
            return reply;

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(String key, String value) {
        execute("INSERT " + key + " " + value);
    }

    public String get(String key) {
        String query = execute("GET " + key);

        assert query != null;
        if (query.equals("GET NULL")) return null;

        return query;
    }

    public void set(String key, String value) {
        String query = execute("SET " + key + " " + value);

        assert query != null;
        if (query.equals("SET NULL")) {
            try {
                throw new InvalidDataException("Set: " + key);
            } catch (InvalidDataException e) {
                e.printStackTrace();
            }
        }
    }

    public void remove(String key) {
        String query = execute("REMOVE " + key);

        assert query != null;
        if (query.equals("REMOVE NULL")) {
            try {
                throw new InvalidDataException("Remove: " + key);
            } catch (InvalidDataException e) {
                e.printStackTrace();
            }
        }
    }

    public void clear() {
        execute("CLEAR");
    }
}
