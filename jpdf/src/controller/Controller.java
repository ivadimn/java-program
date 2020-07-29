package controller;


import core.PDFPage;
import core.Render;
import core.PDFDocument;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {

    PDFDocument document = new PDFDocument();

    public void loadFromFile(File file) throws IOException {
        document.loadFromFile(file);
    }

    public void saveToFile(File file) throws IOException {
        document.saveToFile(file);
    }

    public List<PDFPage> getPages() {
        return document.getPages();
    }

    public void insertImage(BufferedImage img, int index) {
        document.insertPage(img, index);
    }
    public void removeImage(int index) {
        document.removePage(index);
    }

}
