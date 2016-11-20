package ru.ivadimn.client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by vadim on 17.11.16.
 */
public class Session  implements Runnable{

    private String host;
    private int port;
    Socket client;
    private InputStream inStream;
    private OutputStream outStream;
    Scanner in = null;
    PrintWriter out;
    DataInputStream input = null;


    public Session(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public boolean connect() {
        client = new Socket();
        try {
            client.connect(new InetSocketAddress(host, port), 3000);
            inStream = client.getInputStream();
            outStream = client.getOutputStream();
            out = new PrintWriter(outStream);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void run() {
        boolean done = false;
        String line;
        String serverLine;
        in = new Scanner(inStream);
        while(!done && in.hasNext()) {
            serverLine = in.nextLine();
            System.out.println(serverLine);
            if (serverLine.equalsIgnoreCase("exit")) {
                System.out.println("Получили exit");
                done = true;
            }
           /* System.out.print("&>  ");
            //читаем с консоли
            line = console.nextLine();
            if (!line.equalsIgnoreCase("exit"))
                send(line);
            else
                done = true;*/
        }
        close();
   }
   public void close() {
        in.close();
        out.close();
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       System.out.println("закрыли сессию");
    }
    public void send(String msg) {
        out.println(msg);
        out.flush();
    }
}
