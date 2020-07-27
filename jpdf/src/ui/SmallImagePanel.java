package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.*;

public class SmallImagePanel extends JPanel {

    private BufferedImage image;
    private boolean isFocused;

    public SmallImagePanel(BufferedImage image) {
        this.image = image;
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3, false));
        isFocused = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage bi = new
                BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics gl = bi.getGraphics();
        gl.drawImage(image, 0, 0, null);

        double sx = 0.25f;
        double sy = 0.25f;
        AffineTransform transform = new AffineTransform();
        transform.setToScale(sx, sy);
        AffineTransformOp top = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);
        //BufferedImage compImage = top.createCompatibleDestImage(bi, null);

        //Graphics2D gtmp = compImage.createGraphics();
        //gtmp.drawImage(bi, top, 0,0);

        /*
        if (isFocused) {
            //g2.setBackground(Color.BLUE);
            this.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3, false));
        }*/
        g2.drawImage(bi, top, 5, 5);

        //g2.drawImage(compImage, 5, 5, null);
    }

    public boolean isFocused() {
        return isFocused;
    }

    public void setFocused(boolean focused) {
        isFocused = focused;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setBorderColor() {
        if (isFocused) {
            this.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
        }
        else {
            this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3, false));
        }
    }

}
