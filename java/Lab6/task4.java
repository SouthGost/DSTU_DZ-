package Lab6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class task4 extends JFrame {
    private int x = 0, y = 0;
    private String coordinats = "";
    private Color clr = Color.BLACK;
    private final int len = 20;
    public task4() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                x=me.getX();
                y=me.getY();
                coordinats = "x:" + x +" y:" + y;

                repaint();
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke){
                switch (ke.getKeyChar()){
                    case ('b'):
                        clr = Color.BLACK;
                        repaint();
                        break;
                    case ('w'):
                        clr = Color.white;
                        repaint();
                        break;
                    case ('r'):
                        clr = Color.red;
                        repaint();
                        break;
                    case ('g'):
                        clr = Color.green;
                        repaint();
                        break;
                    case ('o'):
                        clr = Color.ORANGE;
                        repaint();
                        break;
                }
            }
        });
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println(coordinats);
        if (coordinats.length() !=0) {
            g.setColor(clr);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(15));
            g.drawString(coordinats,x, y);
        }
    }
    public static void main(String[] args) {
        new task4().setVisible(true);
    }

}
