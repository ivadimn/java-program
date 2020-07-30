package ui;

import common.Utils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ImageFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if(f.isDirectory()) {
            return true;
        }
        String ext = Utils.getFileExtension(f.getName());
        if (ext == null) {
            return false;
        }
        if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("png")
            || ext.equalsIgnoreCase("bmp") || ext.equalsIgnoreCase("gif")) {
            return true;
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "Файлы изображений (.jpg, *.png, *.bmp, *.gif)";
    }
}
