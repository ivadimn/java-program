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
        Scanner in = null;

        try {
            server = new ServerSocket(8189);
            incoming = server.accept();
            Thread thread = new Thread(new ClientSession(incoming));
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
