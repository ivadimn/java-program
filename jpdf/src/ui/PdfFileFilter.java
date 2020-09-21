package ui;

import common.Utils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PdfFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if(f.isDirectory()) {
            return true;
        }
        String ext = Utils.getFileExtension(f.getName());
        if (ext == null) {
            return false;
        }
        if (ext.equalsIgnoreCase("pdf")) {
            return true;
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "Файлы формата PDF (*.pdf)";
    }
}
