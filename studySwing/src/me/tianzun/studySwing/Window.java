package me.tianzun.studySwing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.*;

public class Window extends JFrame{
    private static String stringURL;

    public static void setStringURL(String s) {
        stringURL = s;
    }

    private BufferedImage image;

    public Window(String title){
        try {
            image = ImageIO.read(new URL(stringURL));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            add(new CanvasPanel());
            //setSize(image.getWidth(null),image.getHeight(null));
            setSize(image.getWidth(),image.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setTitle(title);
    }
    class CanvasPanel extends Canvas{
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(image,0,0,this);
        }
    }
}
