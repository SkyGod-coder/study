package me.tianzun.studySwing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.*;

public class Window extends JFrame{
    private static String stringURL;

    public void setStringURL(String s) {
        stringURL = s;
    }

    private BufferedImage image;
    private int width;
    private int height;
    private CanvasPanel canvasPanel;

    public Window(String title){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
    }

    public void reload() {
        //修改标题
        setTitle("图片加载中...");
        while (Main.getFlag()) {
            Main.setFlag(false);
            //重新获取随机图片直链
            setStringURL(JsonManager.getURL());
            //加载图片
            loadPhoto();
        }
        Main.setFlag(true);
        //修改标题
        setTitle("欣赏美图，心情愉悦");
    }

    public void loadPhoto(){
        try {
            //加载Image
            image = ImageIO.read(new URL(stringURL));
            //长宽
            width = image.getWidth();
            height = image.getHeight();
            //控制像素在1K以内
            while(width>1920 || height>1080){
                width/=2;
                height/=2;
            }
            //绘制
            canvasPanel = new CanvasPanel();
            //添加鼠标侦听器，用于侦听单机事件
            canvasPanel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    reload();
                }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {}

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {
                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                }
            });
            //移除画布
            if (canvasPanel != null) {
                remove(canvasPanel);
            }
            //将画布添加到窗口
            add(canvasPanel);
            //设置窗口大小与图片一直
            setSize(width, height);
        } catch (IOException e) {
            Main.setFlag(true);
            e.printStackTrace();
        }
    }
    //内部类，重写paint
    class CanvasPanel extends Canvas{
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(image,0,0,width,height,this);
        }
    }
}
