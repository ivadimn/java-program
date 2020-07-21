package controller;

import core.Render;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    public void generateImages(File f) {
        List<BufferedImage> images = null;
        try {
            images = Render.getImageList(f.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
