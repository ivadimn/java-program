package ru.ivadimn.chatserver;

import ru.ivadimn.chatserver.chat.ChatServer;

import java.util.Scanner;

/**
 * Created by vadim on 22.11.16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ChatServer cs= new ChatServer();
        cs.start();
        String input;
        while (!(input = console.nextLine()).equals("exit"));
        cs.stop();

    }
}
