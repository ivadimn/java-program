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
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, null);
    }


}
