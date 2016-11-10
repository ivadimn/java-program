package ru.ivadimn.swing;

import javax.swing.*;

/**
 * Created by vadim on 10.11.16.
 */
public class Form3 extends JFrame {
     public Form3() {
         setTitle("BoxLayoutDemo");
         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         setBounds(500, 500, 500, 300);
         JButton[] jbs = new JButton[10];
         setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
         for (int i = 0; i < jbs.length; i++) {
             jbs[i] = new JButton("#" + i);
             jbs[i].setAlignmentX(CENTER_ALIGNMENT);
             add(jbs[i]);
         }
         setVisible(true);
     }

}
