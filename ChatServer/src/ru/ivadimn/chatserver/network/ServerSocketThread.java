package ru.ivadimn.chatserver.network;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by vadim on 22.11.16.
 */
public class ServerSocketThread extends Thread {

    private int timeout;
    private int port;
    private String name;
    private ServerSocket server;

    public ServerSocketThread(String name, int port, int timeout) {
        super(name);
        this.port = port;
        this.timeout = timeout;
    }

    @Override
    public void run() {

        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
