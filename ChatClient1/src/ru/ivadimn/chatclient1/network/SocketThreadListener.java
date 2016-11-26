package ru.ivadimn.chatclient1.network;

import java.net.Socket;

/**
 * Created by vadim on 26.11.2016.
 */
public interface SocketThreadListener {
    void onStartSocketThread(SocketThread thread, Socket socket);
    void onStopSocketThread(SocketThread thread, Socket socket);

    void onSocketIsReady(SocketThread thread, Socket socket);
    void onReceivedString(SocketThread thread, Socket socket, String value);
}
