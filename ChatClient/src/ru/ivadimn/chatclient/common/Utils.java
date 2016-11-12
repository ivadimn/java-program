package ru.ivadimn.chatclient.common;

import javax.swing.*;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vadim on 11.11.16.
 */
public class Utils {
    public static final String CHAT_CLIENT = "Chat Client";
    public static final String BTN_LOGIN_CAPTION = "Login";
    public static final String BTN_SEND_CAPTION = "Send";
    public static final String ADDRESS_TOOLTIP = "IP - адрес сервера";


    public static final String FILE_NAME = "chat.log";

    public static void  writeLog(String message) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(FILE_NAME, true));
            printWriter.println(message);
            printWriter.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception : ", JOptionPane.ERROR_MESSAGE);
        }
    }
}
