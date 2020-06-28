package ui;

import core.Render;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {

    private PdfImagesPanel imagesPanel;

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 700);
        setTitle("PDF Manager");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(true);

        try {
            imagesPanel = new PdfImagesPanel(Render.getImageList("test/doc.pdf"));
            JScrollPane pane = new JScrollPane(imagesPanel);
            add(pane, BorderLayout.WEST);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setVisible(true);
    }
}
