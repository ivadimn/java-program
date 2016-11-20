package ru.ivadimn.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by vadim on 20.11.2016.
 */
public class ClientSession implements Runnable {

    private Socket socket;
    PrintWriter out = null;
    Scanner in = null;

    public ClientSession(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        boolean done = false;
        try {
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());
            send("Hello client");
            while (!done && in.hasNext()) {
                String line = in.nextLine();
                System.out.println(line);
                send("Echo: " + line);
                if (line.trim().equals("exit"))
                    done = true;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            close();
        }
    }

    public void send(String msg) {
        out.println(msg);
        out.flush();
    }
    public void close() {
        in.close();
        out.close();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
