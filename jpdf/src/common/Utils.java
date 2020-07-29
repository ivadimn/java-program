package common;

import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Utils {

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

    public static BufferedImage getImageFromFile(File file) throws IOException {
        return ImageIO.read(file);
    }
}
