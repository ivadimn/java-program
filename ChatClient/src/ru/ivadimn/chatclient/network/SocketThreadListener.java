package ru.ivadimn.chatclient.network;

import java.net.Socket;

/**
 * Created by vadim on 24.11.16.
 */
public interface SocketThreadListener {
    void onStartSocketThread(SocketThread thread, Socket socket);
    void onStopSocketThread(SocketThread thread, Socket socket);

    void onSocketIsReady(SocketThread thread, Socket socket);
    void onReceivedString(SocketThread thread, Socket socket, String value);
}
