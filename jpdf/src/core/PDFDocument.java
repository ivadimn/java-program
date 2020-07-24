package core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PDFDocument {
    private List<BufferedImage> pages;

    public PDFDocument() {
        pages = new LinkedList<>();
    }

    public List<BufferedImage> getPages() {
        return pages;
    }

    public void addPage(BufferedImage image) {
        pages.add(image);
    }

    public void removePage(int index) {
        pages.remove(index);
    }

    public void loadFromFile(File file) throws IOException {
        List<BufferedImage> images = Render.getImageList(file);
        pages.addAll(images);
    }

    public void saveToFile(File file) {

    }

    public void saveAsImages() {

    }

}
