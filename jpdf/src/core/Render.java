package core;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.PDFRenderer;
import ui.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Render {

    public static List<BufferedImage> getImageList(PDDocument document) throws IOException  {

       List<BufferedImage> images = new ArrayList<>();
       PDFRenderer renderer = new PDFRenderer(document);
       int numPages = document.getNumberOfPages();
       for (int i = 0; i < numPages; i++) {
           BufferedImage image = renderer.renderImage(i); // Windows native DPI
           images.add(image);
       }
       return images;
    }

    public static PDDocument loadDocument(File file) throws IOException{
        return PDDocument.load(file);
    }

    public static void saveToFile(PDDocument doc, List<PDFPage> pages, File file) throws IOException {
        PDDocument targetDoc = new PDDocument();
        for (PDFPage page : pages) {
            if (page.isInDocument()) {
                targetDoc.addPage(doc.getPage(page.getNumPage()));
            }
            else {
                PDPage p = new PDPage();
                targetDoc.addPage(p);
                imageToPage(targetDoc, page.getImage(), p);
            }
        }
        targetDoc.save(file);
    }
    public static PDDocument insertImage(PDDocument doc, BufferedImage img, int index) throws IOException {

        PDDocument docTarget = new PDDocument();
        PDPage page = new PDPage();
        int numPages = doc.getNumberOfPages();
        int count = 0;
        int it = 0;
        while (count < numPages) {
            if (it != index) {
                docTarget.addPage(doc.getPage(count++));
                it++;
            }
            else {
                docTarget.addPage(page);
                imageToPage(docTarget, img, page);
                it++;
            }
        }
        return docTarget;
    }

    public static void savePdf(PDDocument doc, File file) throws IOException {
        doc.save(file);
    }

    private static void imageToPage(PDDocument doc, BufferedImage img, PDPage page) throws IOException {
        // createFromFile is the easiest way with an image file
        // if you already have the image in a BufferedImage,
        // call LosslessFactory.createFromImage() instead
        //PDImageXObject pdImage = PDImageXObject.createFromByteArray(file, doc);
        PDImageXObject pdImage = LosslessFactory.createFromImage(doc, img);
        // draw the image at full size at (x=20, y=20)
        try (PDPageContentStream contents = new PDPageContentStream(doc, page))  {
            // draw the image at full size at (x=20, y=20)
            contents.drawImage(pdImage, 20, 20);
            // to draw the image at half size at (x=20, y=20) use
            // contents.drawImage(pdImage, 20, 20, pdImage.getWidth() / 2, pdImage.getHeight() / 2);
        }
    }

}
