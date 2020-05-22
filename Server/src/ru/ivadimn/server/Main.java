package ru.ivadimn.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by vadim on 16.11.16.
 */
public class Main {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket incoming = null;
        ClientSession s = null;


        try {
            server = new ServerSocket(8189);
            incoming = server.accept();
            s = new ClientSession(incoming);
            Thread thread = new Thread(s);
            thread.start();
            inputForClient(thread, s);
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void inputForClient(Thread t, ClientSession s) {
        String line;
        Scanner console = new Scanner(System.in);
        while(true && t.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("&>  ");
            //читаем с консоли
            line = console.nextLine();
            s.send(line);
            if (line.equalsIgnoreCase("exit")) {
                s.close();
                break;
            }
        }
    }

}
