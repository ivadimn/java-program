package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PdfImagesPanel extends JPanel {

    private List<SmallImagePanel> imagePanelList = new ArrayList<>();
    private SmallImagePanel focusPanel = null;
    DrawImageListener imageListener;

    public PdfImagesPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(150, 150));
    }


    public void setData(List<BufferedImage> images) {
        this.removeAll();

        for (BufferedImage img : images) {
            final SmallImagePanel smallImagePanel = new SmallImagePanel(img);
            imagePanelList.add(smallImagePanel);
            add(smallImagePanel);
            smallImagePanel.addMouseListener((MouseAdapter) new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        if (focusPanel != null) {
                            focusPanel.setFocused(false);
                            focusPanel.setBorderColor();
                        }
                        focusPanel = smallImagePanel;
                        focusPanel.setFocused(true);
                        focusPanel.setBorderColor();
                        if (imageListener != null) {
                            imageListener.drawImage(focusPanel.getImage());
                        }
                    }
                }
            });
        }
    }

    public void refresh() {
        //revalidate();
        updateUI();
    }

    public void setImageListener(DrawImageListener imageListener) {
        this.imageListener = imageListener;
    }
}
