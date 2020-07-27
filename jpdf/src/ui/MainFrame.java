package ui;

import controller.Controller;
import core.Render;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {

    private PdfImagesPanel imagesPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private BigImagePanel bigImagePanel;

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 700);
        setTitle("PDF Manager");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(true);

        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new PdfFileFilter());
        controller = new Controller();

        setJMenuBar(createMenuBar());
        fileChooser = new JFileChooser();
        controller = new Controller();

        imagesPanel = new PdfImagesPanel();
        JScrollPane pane = new JScrollPane(imagesPanel);
        add(pane, BorderLayout.WEST);
        imagesPanel.setData(controller.getPages());
        imagesPanel.setImageListener(new DrawImageListener() {
            @Override
            public void drawImage(BufferedImage image) {
                bigImagePanel.setImage(image);
                bigImagePanel.updateUI();
            }
        });
        bigImagePanel = new BigImagePanel();
        add(new JScrollPane(bigImagePanel), BorderLayout.CENTER);
        setJMenuBar(createMenuBar());

        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem openFileItem = new JMenuItem("Open ...");
        JMenuItem closeFileItem = new JMenuItem("Close");
        JMenuItem saveFileItem = new JMenuItem("Save");
        JMenuItem saveAsFileItem = new JMenuItem("Save as ...");

        JMenuItem exportDataItem = new JMenuItem("Export data ...");
        JMenuItem importDataItem = new JMenuItem("Import data ...");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(openFileItem);
        fileMenu.add(closeFileItem);
        fileMenu.addSeparator();
        fileMenu.add(saveFileItem);
        fileMenu.add(saveAsFileItem);
        fileMenu.addSeparator();
        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);


        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        openFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile());
                        imagesPanel.setData(controller.getPages());
                        imagesPanel.refresh();
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Could not load data from file.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        saveFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Could not save data to file.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
        showFormItem.setSelected(true);
        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

        showFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();

                imagesPanel.setVisible(menuItem.isSelected());

            }
        });

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        openFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        saveFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));



        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Do you really want to exit the application",
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
                if (action == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        return menuBar;
    }
}
