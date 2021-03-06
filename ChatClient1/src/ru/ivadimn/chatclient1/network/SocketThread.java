package ru.ivadimn.chatclient1.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by vadim on 26.11.2016.
 */
public class SocketThread extends Thread {
    private final SocketThreadListener eventListener;
    private final Socket socket;
    private DataOutputStream out;

    public SocketThread(String name, SocketThreadListener eventListener, Socket socket) {
        super(name);
        this.eventListener = eventListener;
        this.socket = socket;
        start();
    }

    @Override
    public void run() {
        try {
            eventListener.onStartSocketThread(this, socket);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            eventListener.onSocketIsReady(this, socket);
            while (!isInterrupted()) {
                String msg = in.readUTF();
                eventListener.onReceivedString(this, socket, msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            eventListener.onStopSocketThread(this, socket);
        }
    }

    public synchronized boolean sendMsg(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            close();
            return false;
        }
    }

    public synchronized void close(){
        interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
