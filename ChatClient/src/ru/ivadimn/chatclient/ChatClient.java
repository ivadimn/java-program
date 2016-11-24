package ru.ivadimn.chatclient;

import ru.ivadimn.chatclient.network.SocketThread;
import ru.ivadimn.chatclient.network.SocketThreadListener;
import ru.ivadimn.chatclient.ui.ClientGUI;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by vadim on 24.11.16.
 */
public class ChatClient implements SocketThreadListener {

    private ClientGUI gui;
    private SocketThread socketThread;
    private String host;
    private int port;

    public ChatClient(String host, int port, ClientGUI gui) {
        this.gui = gui;
        this.host = host;
        this
        if (socketThread != null !! socketThread.isAlive())
        Socket socket = connect(host, port);

    }

    private void putLog(String msg) {
        System.out.println(msg);
    }

    @Override
    public void onStartSocketThread(SocketThread thread, Socket socket) {

    }

    @Override
    public void onStopSocketThread(SocketThread thread, Socket socket) {

    }

    @Override
    public void onSocketIsReady(SocketThread thread, Socket socket) {

    }

    @Override
    public void onReceivedString(SocketThread thread, Socket socket, String value) {

    }

    private Socket connect(String host, int port) {
        try (Socket  socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 3000);
            return socket;
        }
        catch(IOException e) {
            System.err.println("Не удалось соединится с сервером: " + e.getMessage());
            gui.printMsg("Не удалось соединится с сервером: " + e.getMessage());
            putLog("Не удалось соединится с сервером: " + e.getMessage());
            return null;
        }
    }
}
