package ru.ivadimn.chatclient1.ui;

/**
 * Created by vadim on 27.11.2016.
 */
public interface Information {
    public void printMessage(String msg);
    public void updateUI(boolean param);
    public String getLogin();
    public String getPassword();
}
