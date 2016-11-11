package ru.ivadimn.chatclient;

import ru.ivadimn.chatclient.ui.ClientGUI;

import java.awt.*;

/**
 * Created by vadim on 11.11.16.
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
    }
}
