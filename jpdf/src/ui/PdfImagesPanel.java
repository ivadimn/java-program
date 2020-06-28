package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PdfImagesPanel extends JPanel {

    List<SmallImagePanel> imagePanelList = new ArrayList<>();

    public PdfImagesPanel(List<BufferedImage> images) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //this.setLayout(new ScrollPaneLayout());
        this.setBackground(Color.yellow);
        this.setPreferredSize(new Dimension(200, 900));
        //add(new JButton("Click"));

        for (BufferedImage img : images) {
            SmallImagePanel smallImagePanel = new SmallImagePanel(img);
            imagePanelList.add(smallImagePanel);
            add(smallImagePanel);
        }


    }
}
