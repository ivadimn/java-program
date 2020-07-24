package common;

public class Utils {
<<<<<<< HEAD
    public static String getFileExtension(String fileName) {
        int pointIndex = fileName.lastIndexOf(".");
        if (pointIndex == -1) {
            return null;
        }
        if (pointIndex == fileName.length() - 1) {
            return null;
        }
        return fileName.substring(pointIndex + 1, fileName.length());
=======
    public static String getFileExtension(String name) {

        int pointIndex = name.lastIndexOf(".");
        if (pointIndex == -1) {
            return null;
        }
        if (pointIndex == name.length() - 1) {
            return null;
        }
        return name.substring(pointIndex + 1, name.length());
>>>>>>> new version
    }
}
