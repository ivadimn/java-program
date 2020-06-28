package core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;


public class Render {

    public static List<BufferedImage> getImageList(String pdfFile) throws IOException  {
       List<BufferedImage> images = new ArrayList<>();
       PDDocument document = PDDocument.load(new File(pdfFile));
       PDFRenderer renderer = new PDFRenderer(document);
       int numPages = document.getNumberOfPages();
       for (int i = 0; i < numPages; i++) {
           BufferedImage image = renderer.renderImage(i); // Windows native DPI
           images.add(image);
       }
       return images;
    }
}
