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
    Socket socket;

    public ChatClient(String host, int port, ClientGUI gui) {
        this.gui = gui;
        this.host = host;
        this.port = port;

    }
    public void start() {
        if (socketThread != null && socketThread.isAlive()) {
            gui.printMsg("Подключение уже установлено");
            return;
        }
        socket = connect(host, port);
        if (socket != null) {
            socketThread = new SocketThread("Client - " + host + ":" + port, socket, this);
        }
        else {
            gui.printMsg("Не удалось подключиться к серверу");
        }
    }

    private void putLog(Thread thread, String msg) {
        System.out.println(thread.getName() + " : " + msg);
    }

    @Override
    public void onStartSocketThread(SocketThread thread, Socket socket) {
        putLog(thread, "started " + socket);
    }

    @Override
    public void onStopSocketThread(SocketThread thread, Socket socket) {
        putLog(thread, "stoped " + socket);
    }

    @Override
    public void onSocketIsReady(SocketThread thread, Socket socket) {

    }

    @Override
    public void onReceivedString(SocketThread thread, Socket socket, String value) {
        gui.printMsg(value);
    }

    private Socket connect(String host, int port) {
        try (Socket  socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 3000);
            return socket;
        }
        catch(IOException e) {
            System.err.println("Не удалось соединится с сервером: " + e.getMessage());
            gui.printMsg("Не удалось соединится с сервером: " + e.getMessage());
            return null;
        }
    }

    public void sendMsg(String msg) {
        socketThread.sendMsg(msg);
    }
}
