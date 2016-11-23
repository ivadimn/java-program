package ru.ivadimn.chatserver.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by vadim on 22.11.16.
 */
public class ServerSocketThread extends Thread {

    private final ServerSocketThreadListener eventListener;
    private int timeout;
    private int port;

    public ServerSocketThread(String name, ServerSocketThreadListener eventListener, int port, int timeout) {
        super(name);
        this.eventListener = eventListener;
        this.port = port;
        this.timeout = timeout;
        start();
    }

    @Override
    public void run() {
        eventListener.onStartServerThread(this);
        try (ServerSocket server = new ServerSocket(port)){
            server.setSoTimeout(timeout);
            eventListener.onCreateServerSocket(this, server);
            while(!isInterrupted()) {
                Socket socket;
                try {
                    socket = server.accept();
                } catch (SocketTimeoutException e){
                    eventListener.onTimeOutSocket(this, server);
                    continue;
                }
                eventListener.onAcceptedSocket(this, socket); //освобождене сокета выполняет листнер
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            eventListener.onStopServerThread(this);
        }
    }
}
