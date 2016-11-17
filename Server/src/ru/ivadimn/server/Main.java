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

    public static PrintWriter out = null;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket incoming = null;
        Scanner in = null;

        try {
                server = new ServerSocket(8189);
                incoming = server.accept();
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                in = new Scanner(inStream);
                out = new PrintWriter(outStream);
                send("Hello! Enter BYE to exit");
                boolean done = false;
                while (!done && in.hasNext()) {
                    String line = in.nextLine();
                    System.out.println(line);
                    send("Echo: " + line);
                    if (line.trim().equals("BYE"))
                        done = true;
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
            try {
                incoming.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void send(String msg) {
        out.println(msg);
        out.flush();
    }
}
