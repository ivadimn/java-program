import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdfparser.FDFParser;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;


public class PDFLoad {
    public static void main(String args[]) throws IOException {

        //Loading an existing document
        File file = new File("hello.pdf");
        PDDocument document = PDDocument.load(file);

        System.out.println("PDF loaded");

        //Adding a blank page to the document
        document.addPage(new PDPage());

        //Saving the document
        document.save("hello.pdf");

        //Closing the document
        document.close();

    }
}
