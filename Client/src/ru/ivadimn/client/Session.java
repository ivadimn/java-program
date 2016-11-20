package ru.ivadimn.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

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
        Scanner console = new Scanner(System.in);
        System.out.println("вошли в run");
           try {
                in = new Scanner(inStream);
                while(!done && in.hasNext()) {
                    String line = in.nextLine();
                    System.out.println(line);
                    if (line.equalsIgnoreCase("exit")) {
                        break;
                    }
                    System.out.println("&>");
                    //читаем с консоли
                    line = console.nextLine();
                    if (!line.equalsIgnoreCase("exit")) {
                        send(line);
                    }
                    else
                        done = true;
                }
           }
           finally {
              close();
           }
   }

    private void close() {
        in.close();
        out.close();
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(String msg) {
        out.println(msg);
        out.flush();
    }
}
