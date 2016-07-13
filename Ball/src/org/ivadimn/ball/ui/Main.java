package org.ivadimn.ball.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vadim on 10.07.16.
 */
public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ball = new BallFrame();
            }
        });
    }
}
