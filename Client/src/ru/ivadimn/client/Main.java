package ru.ivadimn.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by vadim on 16.11.16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String line;
        Session s = new Session("localhost", 8189);
        s.connect();
        Thread t = new Thread(s);
        t.start();
        while(true) {
            System.out.println("&>  ");
            //читаем с консоли
            line = console.nextLine();
            if (!line.equalsIgnoreCase("exit"))
                s.send(line);
            else
                break;
        }
    }
}
