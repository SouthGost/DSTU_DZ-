package Lab6;

import java.awt.*; // импортируем все имена из пакета AWT
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO; // импортируем только имя класса ImageIO
import javax.swing.*;

class task6 extends JFrame {
    private BufferedImage im;
    public task6() {
        String imFile = System.getProperty("user.dir") + "\\src\\Lab6\\denis.jpg";
        System.out.println(imFile);
        try {
            im = ImageIO.read(new File(imFile));

            BufferedImage im2 = ImageIO.read(new File(imFile));
            int blureRange = 2;
            for(int i=0;i<im.getWidth();i++){
                for(int j=0;j<im.getHeight();j++){
                    int pixel = im.getRGB(i,j);
                    for(int x=-blureRange/2;x<=blureRange/2;x++){
                        for(int y=-blureRange/2;y<=blureRange/2;y++){
                            if((i+x>=0) && (j+y>=0) && (i+x<im.getWidth()) && (j+y<im.getHeight()) && !((x==0) && (y==0))){
                                pixel += im.getRGB(i+x,j+y);
                            }
                        }
                    }
                    //System.out.print(pixel + " ");
                    pixel /= blureRange*blureRange;
                    im2.setRGB(i,j,pixel);
                }
                //System.out.print("\n");
            }
            im = im2;

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
            Graphics2D g2 = (Graphics2D) g;
            g2.rotate(Math.toRadians(180), im.getHeight() / 2, im.getWidth() / 2);
            g.drawImage(im,0, 0,w,h,null);

        }
    }
    public static void main(String[] args) {
        new task6().setVisible(true);
    }
}
