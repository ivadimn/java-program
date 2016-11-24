package ru.ivadimn.chatclient.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by vadim on 24.11.16.
 */
public class SocketThread extends Thread {
    private SocketThreadListener eventListener;
    private DataOutputStream out;
    private Socket socket;

    public SocketThread(String name, Socket soket, SocketThreadListener listener) {
        super(name);
        this.socket = soket;
        this.eventListener = listener;
        start();
    }

    @Override
    public void run() {
        eventListener.onStartSocketThread(this, socket);
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            eventListener.onSocketIsReady(this, socket);
            while(!isInterrupted()) {
                String msg = in.readUTF();
                eventListener.onReceivedString(this, socket, msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        eventListener.onStopSocketThread(this, socket);
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
