package Lab6;

import java.awt.*;
import javax.swing.*;

public class Sin {
    private JFrame frame;
    private JPanel panel;
    public Sin () {
        frame = new JFrame("task1");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel() { // внутренний класс-наследник JPanel
            @Override
            public void paintComponent(Graphics g) {
                int w = getWidth(), h = getHeight();
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, w, h);
                Graphics2D g2 = (Graphics2D)g;
                g2.setStroke(new BasicStroke(1)); // толщина линий - 3 пикселя
                int x0=150;
                int y0=150;
                g.setColor(Color.white);
                g.drawLine(150, 0, 150, 300);
                g.drawLine(0, 150, 300, 150);
                int scale = 40;
                for(double x = x0-Math.PI*scale;x<=x0+(Math.PI+1)*scale;x+=Math.PI*scale/2){
                    g.drawLine((int)x, y0+2, (int)x, y0-2);
                }
                for(int y = y0-3*scale;y<=y0+3*scale;y+=scale){
                    g.drawLine(x0+2, y, x0-2, y);
                }

                for(double x = x0-Math.PI*scale;x<=x0+(Math.PI)*scale;x++){
                    g.drawLine((int)x, (int)-(Math.sin((x-x0)/scale)*scale)+y0, (int)x+1, (int)-(Math.sin((x+1-x0)/scale)*scale)+y0);
                }
            }
        };
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Sin();
    }
}
