package Lab4;

import javax.swing.*;
import java.awt.*;

public class Drow {

    static class MyCanvas extends Canvas {

        int enter = 0;

        public void paint(Graphics g) {
            g.setColor(Color.BLACK);
            g.drawRect(5,5+enter,100,100);
            g.drawString("HAY",10,16+enter);
            enter+=110;
            g.drawRect(5,5+enter,100,100);
            g.drawString("YOW",10,16+enter);
            enter=0;
        }
    }

    public static void main(String[] args) {
        Canvas canvas = new MyCanvas();
        JFrame frame = new JFrame("nameOf");
        frame.setSize(700,400);
        frame.add(canvas);
        frame.setVisible(true);
    }
}
