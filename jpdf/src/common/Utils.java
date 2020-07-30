package common;

import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import ui.ImageFileFilter;
import ui.PdfFileFilter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Utils {

    public static final PdfFileFilter PDF_FILES = new PdfFileFilter();
    public static final ImageFileFilter IMAGE_FILES = new ImageFileFilter();

    public static String getFileExtension(String fileName) {
        int pointIndex = fileName.lastIndexOf(".");
        if (pointIndex == -1) {
            return null;
        }
        if (pointIndex == fileName.length() - 1) {
            return null;
        }
        return fileName.substring(pointIndex + 1, fileName.length());
    }

    public static String getClearFileName(String fileName) {
        int pointIndex = fileName.lastIndexOf(".");
        if (pointIndex == -1) {
            return fileName;
        }
        return fileName.substring(0, pointIndex);
    }

    public static String getFilePath(String fullPath) {
        int slashIndex = fullPath.lastIndexOf("/");
        if (slashIndex == -1) {
            return "";
        }
        return fullPath.substring(0, slashIndex + 1);
    }

    public static BufferedImage getImageFromFile(File file) throws IOException {
        return ImageIO.read(file);
    }
}
