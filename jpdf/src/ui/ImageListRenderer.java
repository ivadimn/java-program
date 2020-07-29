package ui;

import core.PDFPage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageListRenderer extends DefaultListCellRenderer {
    private SmallImagePanel panel;
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        if (value instanceof PDFPage) {
            panel = new SmallImagePanel(((PDFPage) value).getImage());
            panel.setFocused(isSelected);
            return panel;
        }
        else {
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }
}
