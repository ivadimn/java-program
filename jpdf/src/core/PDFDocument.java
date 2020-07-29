package core;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PDFDocument {
    private List<PDFPage> pages;
    private PDDocument document;

    public PDFDocument() {
        pages = new LinkedList<>();
    }

    public List<PDFPage> getPages() {
        return pages;
    }

    public void insertPage(BufferedImage image, int index) {
        pages.add(index, new PDFPage(image, false, -1));
    }

    public void removePage(int index) {
        pages.remove(index);
    }

    public void loadFromFile(File file) throws IOException {
        document = Render.loadDocument(file);
        if (document != null) {
            List<BufferedImage> images = Render.getImageList(document);
            images.forEach(img -> pages.add(new PDFPage(img, true, images.indexOf(img))));
        }

    }

    public void saveToFile(File file) throws IOException {
        Render.saveToFile(document, pages, file);
    }

    public void saveAsImages() {

    }

}
