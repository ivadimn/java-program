package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.RescaleOp;

public class SmallImagePanel extends JPanel {

    private BufferedImage image;
    private boolean isFocused;

    public SmallImagePanel(BufferedImage image) {
        this.image = image;
        setPreferredSize(new Dimension(image.getWidth() / 4 + 10,
                image.getHeight() / 4 + 10));

        this.setBackground(Color.WHITE);
        isFocused = false;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = image.getWidth(null);
        int h = image.getHeight(null);
        BufferedImage bi = new
                BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics gl = bi.getGraphics();
        gl.drawImage(image, 0, 0, null);

        double sx = 0.25f;
        double sy = 0.25f;
        AffineTransform transform = new AffineTransform();
        transform.setToScale(sx, sy);
        AffineTransformOp top = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);

        /* Draw the image, applying the filter */
        if (isFocused) {
            g2.setBackground(Color.BLUE);
        }
        g2.drawImage(bi, top, 5, 5);
    }

    private BufferedImage getImage() {
        return image;
    }
}
