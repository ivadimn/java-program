package ui;

import java.awt.image.BufferedImage;

public interface ImageListener {
    public void drawImage(BufferedImage image);
    public void insertImageFromFile(int index);
    public void removeImage(int index);
    public void saveAsImages();

}
