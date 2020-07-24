package controller;

<<<<<<< HEAD
import core.Render;
=======
import core.PDFDocument;
>>>>>>> new version

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
<<<<<<< HEAD
    public void generateImages(File f) {
        List<BufferedImage> images = null;
        try {
            images = Render.getImageList(f.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

=======
    PDFDocument document = new PDFDocument();

    public void loadFromFile(File file) throws IOException {
        document.loadFromFile(file);
    }

    public void saveToFile(File file) throws IOException {
        document.saveToFile(file);
    }

    public List<BufferedImage> getPages() {
        return document.getPages();
>>>>>>> new version
    }
}
