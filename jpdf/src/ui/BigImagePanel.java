package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BigImagePanel extends JPanel {
    private BufferedImage image;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null) return;
        Graphics2D g2 = (Graphics2D) g;
        Dimension size = getSize();
        int w = image.getWidth();
        int x = 0;
        if (size.width > w) {
            x = (size.width - w) / 2;
        }
        g2.drawImage(image, x, 0, null);
    }


}
