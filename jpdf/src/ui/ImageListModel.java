package ui;

import core.PDFPage;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class ImageListModel extends AbstractListModel<PDFPage> {

    private List<PDFPage> list;

    @Override
    public int getSize() {
        return list == null ? 0 : list.size();
    }

    @Override
    public PDFPage getElementAt(int index) {
        return list.get(index);
    }

    public void setData(List<PDFPage> list) {
        this.list = list;
    }

}
