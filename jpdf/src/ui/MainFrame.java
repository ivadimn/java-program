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

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 700);
        setTitle("PDF Manager");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(true);

        imagesPanel = new PdfImagesPanel();
        JScrollPane pane = new JScrollPane(imagesPanel);
        add(pane, BorderLayout.WEST);

        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new PdfFileFilter());
        controller = new Controller();

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
                    controller.generateImages(fileChooser.getSelectedFile());
                }
            }
        });

        saveAsFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fileChooser.getSelectedFile());
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

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = JOptionPane.showInputDialog(MainFrame.this,
                        "Enter your user name", "Enter user name",
                        JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);

                System.out.println(text);
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
