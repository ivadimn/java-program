package ru.ivadimn.chatserver.chat;

import ru.ivadimn.chatserver.network.SocketThread;
import ru.ivadimn.chatserver.network.SocketThreadListener;

import java.net.Socket;

/**
 * Created by vadim on 25.11.2016.
 */
public class ChatSocketThread extends SocketThread {
    private String nick;
    private String login;
    private boolean authorized;

    ChatSocketThread(String name, SocketThreadListener eventListener, Socket socket) {
        super(name, eventListener, socket);
    }

    boolean isAuthorized() {
        return authorized;
    }

    void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    String getNick() {
        return nick;
    }

    void setNick(String nick) {
        this.nick = nick;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
