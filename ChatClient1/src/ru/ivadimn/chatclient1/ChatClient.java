package ru.ivadimn.chatclient1;

import ru.ivadimn.chatclient1.network.SocketThread;
import ru.ivadimn.chatclient1.network.SocketThreadListener;
import ru.ivadimn.chatclient1.ui.ClientGUI;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by vadim on 26.11.2016.
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
    public void connect() {
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), 3000);
            socketThread = new SocketThread("Client - " + host + ":" + port, this, socket);
        }
        catch(IOException e) {
            System.err.println("Не удалось соединится с сервером: " + e.getMessage());
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
        putLog(thread, " is ready " + socket);
    }

    @Override
    public void onReceivedString(SocketThread thread, Socket socket, String value) {
        gui.printMsg(value);
    }


    public void sendMsg(String msg) {
        socketThread.sendMsg(msg);
    }
}
