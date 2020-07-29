package core;

import java.awt.image.BufferedImage;

public class PDFPage {
    private BufferedImage image;
    private boolean inDocument;
    private int numPage;

    public PDFPage(BufferedImage image, boolean inDocument, int numPage) {
        this.image = image;
        this.inDocument = inDocument;
        this.numPage = numPage;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean isInDocument() {
        return inDocument;
    }

    public void setInDocument(boolean inDocument) {
        this.inDocument = inDocument;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }
}
