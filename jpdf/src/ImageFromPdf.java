import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;

public class ImageFromPdf {

    public static void main(String[] args) {
        try {
            String sourceDir = "test/homework08.pdf"; // Pdf files are read from this folder
            String destinationDir = "text"; // converted images from pdf document are saved here



            File sourceFile = new File("test/homework08.pdf");
            File destinationFile = new File(destinationDir);
            if (!destinationFile.exists()) {
                destinationFile.mkdir();
                System.out.println("Folder Created -> "+ destinationFile.getAbsolutePath());
            }
            if (sourceFile.exists()) {
                System.out.println("Images copied to Folder: "+ destinationFile.getName());
                PDDocument document = PDDocument.load(sourceFile);

                PDPageTree pageTree = document.getDocumentCatalog().getPages();
                Iterator<PDPage> pdPageIterator = pageTree.iterator();
                System.out.println("Total files to be converted -> "+ pageTree.getCount());



                String fileName = sourceFile.getName().replace(".pdf", "");
                int pageNumber = 1;
                while(pdPageIterator.hasNext()) {
                    PDPage page = pdPageIterator.next();
                    BufferedImage image = ImageIO.read(page.getContents());
                    File outputfile = new File(destinationDir + "/" + fileName +"_"+ pageNumber +".png");
                    System.out.println("Image Created -> "+ outputfile.getName());
                    ImageIO.write(image, "png", outputfile);
                    pageNumber++;
                }
                document.close();
                System.out.println("Converted Images are saved at -> "+ destinationFile.getAbsolutePath());
            } else {
                System.err.println(sourceFile.getName() +" File not exists");
            }



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
