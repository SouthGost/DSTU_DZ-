package Lab7;

import java.awt.*; // импортируем все имена из пакета AWT
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO; // импортируем только имя класса ImageIO
import javax.swing.*;

class task2 extends JFrame {
    private BufferedImage im;
    private int rotation = 0;
    private JButton blureButton;
    private JButton rotateButton;

    private void blure(BufferedImage img, int blureRange ){
        for(int i=0;i<im.getWidth();i++){
            for(int j=0;j<im.getHeight();j++){
                int pixel = im.getRGB(i,j);
                int a = (pixel >> 24) & 0xFF;
                int r = (pixel >> 16) & 0xFF;
                int g = (pixel >> 8) & 0xFF;
                int b = pixel & 0xFF;
                for(int x=-blureRange/2;x<=blureRange/2;x++){
                    for(int y=-blureRange/2;y<=blureRange/2;y++){
                        if((i+x>=0) && (j+y>=0) && (i+x<im.getWidth()) && (j+y<im.getHeight()) && !((x==0) && (y==0))){
                            pixel = im.getRGB(i+x,j+y);
                            a = a + ((pixel >> 24) & 0xFF);
                            r = r + ((pixel >> 16) & 0xFF);
                            g = b + ((pixel >> 8) & 0xFF);
                            b = b + (pixel & 0xFF);
                        }
                    }
                }
                //System.out.print(pixel + " ");
                a /= (blureRange*blureRange);
                r /= (blureRange*blureRange);
                g /= (blureRange*blureRange);
                b /= (blureRange*blureRange);
                pixel = (a<<24)|(r<<16)|(g<<8)|(b);
                im.setRGB(i,j,pixel);
            }
            //System.out.print("\n");
        }
        repaint();
    }

    public task2() {
        String imFile = System.getProperty("user.dir") + "\\src\\Lab6\\denis.jpg";
        System.out.println(imFile);
        try {
            im = ImageIO.read(new File(imFile));
            blureButton = new JButton("Blure");
            blureButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    blure(im, 11);
                }
            });
            JPanel panel1 = new JPanel();
            panel1.setLayout(new FlowLayout());
            panel1.add(blureButton);

            rotateButton = new JButton("180 rotate");
            rotateButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    rotation +=180;
                    rotation %= 360;
                    repaint();
                }
            });
            panel1.add(rotateButton);

            add(panel1, BorderLayout.SOUTH);


            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(im.getWidth(),im.getHeight()+50);
            setVisible(true);

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
            if(getWidth()*1.0/(getHeight()-50)>=im.getWidth()*1.0/im.getHeight()){
                h=getHeight()-50;
                w = (int)(((getHeight()-50)*1.0)/im.getHeight()*im.getWidth());
            }else {
                w = getWidth();
                h = (int) ((getWidth() * 1.0) / im.getWidth() * im.getHeight());
            }
            Graphics2D g2 = (Graphics2D) g;
            if(rotation != 0) {
                g2.rotate(Math.toRadians(rotation), h / 2, w / 2);
                g.drawImage(im, 0, 0, w, h , null);
            }else {
                g.drawImage(im, 0, 0, w, h , null);
            }

        }
    }
    public static void main(String[] args) {
        new task2();
    }
}
