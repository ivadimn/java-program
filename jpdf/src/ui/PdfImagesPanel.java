package ui;

import core.PDFPage;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;

public class PdfImagesPanel extends JPanel {

    private JList imageList;
    private ImageListModel listModel;
    private JPopupMenu popup;

    ImageListener imageListener;

    public PdfImagesPanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(150, 0));
        listModel = new ImageListModel();
        imageList = new JList(listModel);
        imageList.setCellRenderer(new ImageListRenderer());
        add(new JScrollPane(imageList), BorderLayout.CENTER);

        imageList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = imageList.getSelectedIndex();
                if (imageListener != null) {
                    imageListener.drawImage(listModel.getElementAt(index).getImage());
                }
            }
        });

        popup = new JPopupMenu();
        JMenuItem insertItem = new JMenuItem("Добавить изображение ...");
        JMenuItem removeItem = new JMenuItem("Удалить страницу");
        popup.add(insertItem);
        popup.add(removeItem);

        imageList.addMouseListener((MouseAdapter) new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(imageList, e.getX(), e.getY());
                }
            }
        });
        insertItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = imageList.getSelectedIndex();
                if (imageListener != null) {
                    imageListener.insertImageFromFile(index + 1);
                    imageList.setSelectedIndex(index + 1);
                    refresh();

                }
            }
        });
    }

    public void setData(List<PDFPage> pages) {
        listModel.setData(pages);
    }

    public void refresh() {
        imageList.updateUI();
    }

    public void setImageListener(ImageListener imageListener) {
        this.imageListener = imageListener;
    }
}
