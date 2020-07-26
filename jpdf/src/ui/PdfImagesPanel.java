package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PdfImagesPanel extends JPanel {

    private List<SmallImagePanel> imagePanelList = new ArrayList<>();

    public PdfImagesPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setPreferredSize(new Dimension(200, 900));
    }


    public void setData(List<BufferedImage> images) {
        this.removeAll();

        for (BufferedImage img : images) {
            SmallImagePanel smallImagePanel = new SmallImagePanel(img);
            imagePanelList.add(smallImagePanel);
            add(smallImagePanel);
        }

    }

    public void refresh() {
        repaint();
    }
}
