package org.opentex.jimel.test;

import org.opentex.jimel.image.DataImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Created by jdborowy on 25/12/2014.
 */
public final class ImageIOHelper {
    public static final DataImage jimelImageOfBufferedImage(BufferedImage image) {
        int[] data = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
        return new DataImage(image.getWidth(), image.getHeight(), data);
    }

    public static final BufferedImage bufferedImageOfJimelImage(DataImage image) {
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        bufferedImage.setRGB(0, 0, image.getWidth(), image.getHeight(), image.getData().clone(), 0, image.getWidth());
        return bufferedImage;
    }

    public static final DataImage open(String pathname) throws IOException {
        return open(new File(pathname));
    }

    public static final void write(DataImage image, String pathname) throws IOException {
        write(image, new File(pathname));
    }

    public static final DataImage open(File file) throws IOException {
        return jimelImageOfBufferedImage(ImageIO.read(file));
    }

    public static final void write(DataImage image, File file) throws IOException {
        String[] tmp = file.getPath().split("\\.");
        if (tmp.length == 1) {
            file = new File(file.getPath() + ".png");
            tmp = file.getPath().split("\\.");
        }
        ImageIO.write(bufferedImageOfJimelImage(image), tmp[tmp.length - 1], file);
    }
}
