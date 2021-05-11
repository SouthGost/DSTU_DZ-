package Lab6;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class task7 extends JFrame {
    private int pogx = 8, pogy = 30;
    private ArrayList<circl> circls;
    private Timer t;
    public task7() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400); //    138
        circls = new ArrayList<>();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                circls.add(new circl(getWidth()-116,getHeight()-138));
            }
        });
        t = new Timer( 100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int w = getWidth();
                int h = getHeight();
                for (circl cir : circls) {
                    cir.x += cir.movex;
                    cir.y += cir.movey;
                    if (cir.x > w - cir.len - 16) {
                        cir.x = w - cir.len - 16;
                        cir.movex *= -1;
                    } else if (cir.x < 0) {
                        cir.x = 0;
                        cir.movex *= -1;
                    }
                    if (cir.y > h - cir.len - 38) {
                        cir.y = h - cir.len - 38;
                        cir.movey *= -1;
                    } else if (cir.y < 0) {
                        cir.y = 0;
                        cir.movey *= -1;
                    }
                }
                repaint();
            }
        });
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (circl cir : circls) {
            g.setColor(cir.color);
            g.fillOval(cir.x + pogx, cir.y + pogy, cir.len, cir.len);
        }
    }
    public static void main(String[] args) {
        new task7().setVisible(true);
    }
}

class circl{
    public int x=0, y=0;
    public int movex = 3, movey = 3;
    public int len = 100;
    public Color color;

    public static Color[] anycolor = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.magenta};

    circl(){
        color= anycolor[(int)(Math.random()*7)];
    }

    circl(int borderx, int bordery){
        x=(int)Math.round(Math.random()*borderx);
        y=(int)Math.round(Math.random()*bordery);
        movex = movey = 1+(int)Math.round(Math.random()*4);
        for(int i =0;i< (int)Math.round(Math.random()); i++){
            movex *= -1;
        }
        for(int i =0;i< (int)Math.round(Math.random()); i++){
            movey *= -1;
        }
        color= anycolor[(int)(Math.random()*7)];
    }
}
