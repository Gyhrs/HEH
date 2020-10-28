package me.tue.utils;

import me.tue.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ImageUtil {

    public static BufferedImage getImage(String path) {
        URL url = Main.class.getResource( "/me/tue/"+ path);
        if(url == null) return null;
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int convertPixelToGreyScale(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = pixel & 0xff;

        int avg = (red + green + blue) / 3;

        return (alpha << 24) | (avg << 16) | (avg << 8) | avg;
    }

    public static List<String> convertImage(BufferedImage img) {
        List<String> strings = new ArrayList<>();
        int width = img.getWidth();
        int height = img.getHeight();
        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                //int pixel = convertPixelToGreyScale(img.getRGB(x, y));
                int pixel = img.getRGB(x,y);
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;
                double Y = 0.2126 * red + 0.7152 * green + 0.0722 * blue;
                if(Y < 50 && alpha != 0) sb.append("**");
                else sb.append("  ");

            }
            strings.add(sb.toString());
        }
        return strings;
    }

    public static void displayImage(String path){
        BufferedImage image = ImageUtil.getImage(path);
        if(image != null){
            List<String> imageLines = ImageUtil.convertImage(image);
            imageLines.forEach(System.out::println);
        }else {
            throw new NullPointerException();
        }
    }

}
