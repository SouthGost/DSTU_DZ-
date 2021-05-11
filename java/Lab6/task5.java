package Lab6;

import java.awt.*; // импортируем все имена из пакета AWT
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO; // импортируем только имя класса ImageIO
import javax.swing.*;

class task5 extends JFrame {
    private BufferedImage im;
    public task5() {
        String imFile = System.getProperty("user.dir") + "\\src\\Lab6\\ABOBA.png";
        System.out.println(imFile);
        try {
            im = ImageIO.read(new File(imFile));
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(im.getWidth(),im.getHeight());

        }
        catch(IOException ioe) {
            im = null;
        }

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (im != null) {
            int w,h;
            if(getWidth()*1.0/getHeight()>=im.getWidth()*1.0/im.getHeight()){
                h=getHeight();
                w = (int)((getHeight()*1.0)/im.getHeight()*im.getWidth());
            }else {
                w = getWidth();
                h = (int) ((getWidth() * 1.0) / im.getWidth() * im.getHeight());
            }
            g.drawImage(im,0, 0,w,h,null);
        }
    }
    public static void main(String[] args) {
        new task5().setVisible(true);
    }
}

