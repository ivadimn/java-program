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
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("localhost", 8189)) {
            InputStream inStream = s.getInputStream();
            OutputStream outStream = s.getOutputStream();
            PrintWriter out= new PrintWriter(outStream);
            Scanner in  = new Scanner(inStream);
            //Scanner console = new Scanner(System.in);
            //String input;
            //while((input = console.nextLine()) != "exit") {
                //System.out.println(input);
                //out.println(input);
                if (in.hasNextLine()) {

                    String line = in.nextLine();
                    System.out.println(line);
                }
            //}
        }
    }
}
