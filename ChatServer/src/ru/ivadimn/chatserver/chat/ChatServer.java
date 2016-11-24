package ru.ivadimn.chatserver.chat;

import ru.ivadimn.chatserver.network.ServerSocketThread;
import ru.ivadimn.chatserver.network.ServerSocketThreadListener;
import ru.ivadimn.chatserver.network.SocketThread;
import ru.ivadimn.chatserver.network.SocketThreadListener;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * Created by vadim on 23.11.16.
 */
public class ChatServer  implements ServerSocketThreadListener, SocketThreadListener {

    public static final int port = 8189;
    private ServerSocketThread serverSocketThread;
    private Vector<SocketThread> clients = new Vector<>();

    public void start() {
        if (serverSocketThread != null && serverSocketThread.isAlive()) {
            System.out.println("Сервер уже запущен.");
            return;
        }
        serverSocketThread = new ServerSocketThread("ServerSocketThread", this, port, 10000);
    }
    public void stop() {
        if (serverSocketThread == null || !serverSocketThread.isAlive()) {
            System.out.println("Сервер уже остановлен.");
            return;
        }
        serverSocketThread.interrupt();
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).close();
        }
    }


    private synchronized void putLog(Thread thread, String msg) {
        System.out.println(thread.getName() + ": " + msg);
    }

    @Override
    public void onStartServerThread(ServerSocketThread thread) {
        putLog(thread, "Сервер запущщен!");
    }

    @Override
    public void onStopServerThread(ServerSocketThread thread) {
        putLog(thread, "Сервер отановлен!");
    }

    @Override
    public void onCreateServerSocket(ServerSocketThread thread, ServerSocket serverSocket) {
        putLog(thread, "начал прослушивать порт!");
    }

    @Override
    public void onAcceptedSocket(ServerSocketThread thread, Socket socket) {
        putLog(thread, "Клиент подключился " + socket);
        String threadName = "SocketThread: " + socket.getInetAddress() + ":" + socket.getPort();
        new SocketThread(threadName, socket, this);
    }

    @Override
    public void onTimeOutSocket(ServerSocketThread thread, ServerSocket serverSocket) {
        putLog(thread, "TimeOutSocket " + serverSocket);
    }
    /////////////////////////////////////////////////////////////////////
    //socketthreadlistener
    @Override
    public void onStartSocketThread(SocketThread thread, Socket socket) {
        putLog(thread, "started " + socket);
    }

    @Override
    public void onStopSocketThread(SocketThread thread, Socket socket) {
        putLog(thread, "stopped " + socket);
        if (!clients.remove(thread)) throw new RuntimeException("Не удалось удалсть поток: " + thread);
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).sendMsg(thread.getName() + ": disconnected.");
        }
    }

    @Override
    public void onSocketIsReady(SocketThread thread, Socket socket) {
        putLog(thread, "Socket is ready " + socket);
        clients.add(thread);
    }

    @Override
    public void onReceivedString(SocketThread thread, Socket socket, String value) {
        thread.sendMsg("Echo: " + value);
    }
}
