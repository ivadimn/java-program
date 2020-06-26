import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;


public class PDFGenerator {
    public static final String DEST = "test/hello.pdf";

    public static void main(String[] args) {
        PDDocument document = null;

        try {
            document = PDDocument.load(new File("test/doc.pdf"));
            PDFRenderer renderer = new PDFRenderer(document);
            int numPages = document.getNumberOfPages();
            for (int i = 0; i < numPages; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 96); // Windows native DPI
                String fileName = String.format("image-%d.jpg", i);
                ImageIO.write(image, "PNG", new File(fileName));
                System.out.println("Writing " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
