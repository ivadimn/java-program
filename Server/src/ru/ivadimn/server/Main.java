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
        Scanner in;
        try {

                server = new ServerSocket(8189);
                incoming = server.accept();
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream);
                out.println("Hello! Enter BYE to exit");
                boolean done = false;
                while (!done && in.hasNextLine()) {
                    String line = in.nextLine();
                    out.println("Echo: " + line);
                    if (line.trim().equals("BYE"))
                        done = true;
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }

    }
}
