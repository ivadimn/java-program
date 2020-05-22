package ru.ivadimn.chatclient1;

import ru.ivadimn.chatclient1.network.SocketThread;
import ru.ivadimn.chatclient1.network.SocketThreadListener;
import ru.ivadimn.chatclient1.ui.ClientGUI;
import ru.ivadimn.chatclient1.ui.Information;

import javax.swing.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by vadim on 26.11.2016.
 */
public class ChatClient implements Thread.UncaughtExceptionHandler, SocketThreadListener {

    private Information info;
    private SocketThread socketThread;
    private String host;
    private int port;
    Socket socket;

    public ChatClient(String host, int port, Information info) {
        this.info = info;
        this.host = host;
        this.port = port;
        Thread.setDefaultUncaughtExceptionHandler(this);

    }
    public boolean connect() {
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), 3000);
            socketThread = new SocketThread("Client - " + host + ":" + port, this, socket);
            return true;
        }
        catch(IOException e) {
            info.printMessage("Не удалось соединится с сервером: " + e.getMessage());
            return false;
        }
    }

    public void disconnect() {
        socketThread.close();
    }


    @Override
    public void onStartSocketThread(SocketThread thread, Socket socket) {
        info.printMessage("Подключились к серверу.");
    }

    @Override
    public void onStopSocketThread(SocketThread thread, Socket socket) {
        info.printMessage("Connection lost");
        info.updateUI(false);
    }

    @Override
    public void onSocketIsReady(SocketThread thread, Socket socket) {
        info.printMessage("Можно передавать данные");
        info.updateUI(true);
        String request = "/auth " + info.getLogin() + " " + info.getPassword();
        socketThread.sendMsg(request);
    }

    @Override
    public void onReceivedString(SocketThread thread, Socket socket, String value) {
        info.printMessage(value);
    }


    public void sendMsg(String msg) {
        socketThread.sendMsg(msg);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        StackTraceElement [] stackTraceElements = e.getStackTrace();
        String msg;
        if(stackTraceElements.length != 0){
            msg = stackTraceElements[0].toString() + ": " + e.getMessage();
        } else {
            msg = "StackTrace пустой";
        }
        JOptionPane.showMessageDialog(null, msg, "Exception: ", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
}
