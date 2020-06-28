import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.lowagie.text.pdf.PdfImage;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfContentReaderTool;
import com.lowagie.text.pdf.parser.PdfTextExtractor;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class PDFRead {
    // PDF to be read
    public static final String READ_PDF = "test/homework08.pdf";
    public static void main(String[] args) {
        PdfReader pdfreader = null;
        try {
            pdfreader = new PdfReader(READ_PDF);
            // get pages in PDF
            int pages = pdfreader.getNumberOfPages();
            PdfTextExtractor pdfTextExtractor = new PdfTextExtractor(pdfreader);
           // Iterate through pages to read content
            for(int i = 1; i <= pages; i++) {
                // Extract content of each page

                String contentOfPage = pdfTextExtractor.getTextFromPage(i, true);
                if (!contentOfPage.isEmpty()) {
                    System.out.println(contentOfPage);
                }
                else {
                    PdfObject pdfObject = pdfreader.getPdfObject(i);
                    byte[] content = pdfObject.getBytes();
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(content));
                    File newFile = new File("test/file0" + i + ".jpg");
                    ImageIO.write(img, "jpg", newFile);
                    System.out.println("Файл записан!");
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if(pdfreader != null) {
                pdfreader.close();
            }
        }
    }
}
