package core;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PDFDocument {
    private LinkedList<BufferedImage> pages;
    private PDDocument document;

    public PDFDocument() {
        pages = new LinkedList<>();
    }

    public LinkedList<BufferedImage> getPages() {
        return pages;
    }

    public void addPage(BufferedImage image) {
        pages.add(image);
    }

    public void insertPage(BufferedImage image, int index) {
        pages.add(index, image);

    }

    public void removePage(int index) {
        pages.remove(index);
    }

    public void loadFromFile(File file) throws IOException {
        document = Render.loadDocument(file);
        if (document != null) {
            List<BufferedImage> images = Render.getImageList(document);
            pages.addAll(images);
        }

    }

    public void saveToFile(File file) {

    }

    public void saveAsImages() {

    }

}
