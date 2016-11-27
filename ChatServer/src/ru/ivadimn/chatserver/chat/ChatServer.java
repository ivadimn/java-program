package ru.ivadimn.chatserver.chat;

import ru.ivadimn.chatserver.db.SQLClient;
import ru.ivadimn.chatserver.network.ServerSocketThread;
import ru.ivadimn.chatserver.network.ServerSocketThreadListener;
import ru.ivadimn.chatserver.network.SocketThread;
import ru.ivadimn.chatserver.network.SocketThreadListener;

import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Created by vadim on 23.11.16.
 */
public class ChatServer  implements ServerSocketThreadListener, SocketThreadListener {
    private ServerSocketThread serverSocketThread;
    private final Vector<ChatSocketThread> clients = new Vector<>();

    public void start(int port){
        if(serverSocketThread != null && serverSocketThread.isAlive()){
            System.out.println("Сервер уже запущен.");
            return;
        }
        serverSocketThread = new ServerSocketThread("ServerSocketThread", this, port, 10000);
        SQLClient.connect();
    }

    public void stop(){
        if(serverSocketThread == null || !serverSocketThread.isAlive()){
            System.out.println("Сервер уже остановлен.");
            return;
        }
        serverSocketThread.interrupt();
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).close();
        }
        SQLClient.disconnect();
    }

    private synchronized void putLog(Thread thread, String msg){
        System.out.println(thread.getName() + ": " + msg);
    }

    //События ServerSocketThread
    @Override
    public void onStartServerThread(ServerSocketThread thread) {
        putLog(thread, "started.");
    }

    @Override
    public void onStopServerThread(ServerSocketThread thread) {
        putLog(thread, "stopped.");
    }

    @Override
    public void onCreateServerSocket(ServerSocketThread thread, ServerSocket serverSocket) {
        putLog(thread, "onCreateServerSocket " + serverSocket);
    }

    @Override
    public void onAcceptedSocket(ServerSocketThread thread, Socket socket) {
        putLog(thread, "Client connected " + socket);
        String threadName = "SocketThread: " + socket.getInetAddress() + ":" + socket.getPort();
        new ChatSocketThread(threadName, this, socket);
    }

    @Override
    public void onTimeOutSocket(ServerSocketThread thread, ServerSocket serverSocket) {
//        putLog(thread, "onTimeOutSocket.");
    }

    //события сокета
    @Override
    public synchronized void onStartSocketThread(SocketThread thread, Socket socket) {
        putLog(thread, "started " + socket);
    }

    @Override
    public synchronized void onStopSocketThread(SocketThread thread, Socket socket) {
        putLog(thread, "stopped " + socket);
        if(!clients.remove((ChatSocketThread) thread))
            throw new RuntimeException("Не удалось удалсть поток: " + thread);
        if(((ChatSocketThread) thread).isAuthorized()){
            for (int i = 0; i < clients.size(); i++) {
                clients.get(i).sendMsg(((ChatSocketThread) thread).getNick() + ": disconnected.");
            }
        }
    }

    @Override
    public synchronized void onSocketIsReady(SocketThread thread, Socket socket) {
        putLog(thread, "Socket is ready " + socket);
        clients.add((ChatSocketThread) thread);
    }

    @Override
    public synchronized void onReceivedString(SocketThread thread, Socket socket, String value) {
        ChatSocketThread chatSocketThread = (ChatSocketThread) thread;
        //        /auth login password
        if(!chatSocketThread.isAuthorized()){
            handleNonAuthorizeMsg(chatSocketThread, value);
            return;
        }
        if (handleMessage((ChatSocketThread) thread, value)) return;

        for (int i = 0; i < clients.size(); i++) clients.get(i).sendMsg( chatSocketThread.getNick() + ": " + value);
    }

    private void handleNonAuthorizeMsg(ChatSocketThread thread, String value) {
        String[] arr = value.split(" ");
        if (arr.length != 3 || !arr[0].equals("/auth")) {
            thread.sendMsg("Authorization error.");
            thread.close();
        } else {
            String nick = SQLClient.getNick(arr[1], arr[2]);
            String login = arr[1];

            //убираем зарегистрированного клиента с таким же логином
            //removeThreadWSameLogin(login);
            //////////////////////////////////////////////////
            if (nick == null) {
                thread.sendMsg("Authorization error.");
                thread.close();
            } else {
                thread.setNick(nick);
                thread.setLogin(login);
                thread.setAuthorized(true);
                for (int i = 0; i < clients.size(); i++) clients.get(i).sendMsg(nick + " connected.");
            }
        }
    }

    private boolean handleMessage(ChatSocketThread thread, String value) {
        if(value.length() > 0 && value.charAt(0) != '/' || value.length() < 2) return false;
        String[] arr = value.split(" ");
        switch (arr[0]) {
            case "/private":
                return true;
            case "/exit":
                thread.close();
                return true;
            case "/kick":
                return true;
            default:
                return false;
        }
    }

    /**
     * ищем клиента с логином - login
     */
     private SocketThread getSameLoginThread(String login) {
        for (int i = 0; i < clients.size(); i++) {
            ChatSocketThread chThread = clients.get(i);
            if(login.equals(chThread.getLogin()))
                return chThread;
        }
        return null;
    }

    /**
     * отключаем клиента с логином
     * @param login
     */
    private void removeThreadWSameLogin(String login) {
        SocketThread socketThread = getSameLoginThread(login);
        if (socketThread != null) {
            clients.remove(socketThread);
            socketThread.close();
        }
    }

}
