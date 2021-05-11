package Lab6;

import javax.swing.*;
import java.awt.*;

public class Curve {
    protected double[] xs;
    protected double[] ys;
    protected final int[] border = {0,0,0,0};

    private JFrame frame;
    private JPanel panel;

    private void constructor() {
        frame = new JFrame("task2");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel() { // внутренний класс-наследник JPanel
            @Override
            public void paintComponent(Graphics g) {
                int w = getWidth(), h = getHeight();
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, w, h);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(1)); // толщина линий - 3 пикселя
                int x0 = w/2;
                int y0 = h/2;
                g.setColor(Color.white);
                g.drawLine(x0, 0, x0, h);
                g.drawLine(0, y0, w, y0);
                int scale = 20;
                for (int x = x0 - (x0/scale) * scale; x <= x0 + (x0/scale) * scale; x += scale) {
                    g.drawLine(x, y0 + 2,  x, y0 - 2);
                }
                for (int y = y0 - (y0/scale) * scale; y <= y0 + (y0/scale) * scale; y += scale) {
                    g.drawLine(x0 + 2, y, x0 - 2, y);
                }
                for(int i=0; i< xs.length-1;i++){
//                    System.out.println( i + ") " +(int)(x0 + xs[i]* scale) + " " + (int)(y0 -ys[i] * scale));
                    if( (x0 + xs[i]* scale >= border[0] && x0 +xs[i]* scale <= border[2] && y0 -ys[i]* scale >= border[1] && y0 -ys[i]* scale <= border[3]) && (x0 + xs[i+1]* scale >= border[0] && x0 +xs[i+1]* scale <= border[2] && y0 -ys[i+1]* scale >= border[1] && y0 -ys[i+1]* scale <= border[3]) ) {
                        g.drawLine((int)(x0 + xs[i] * scale), (int)(y0 - ys[i] * scale), (int)(x0 + xs[i + 1] * scale), (int)(y0 - ys[i + 1] * scale));
                    }
                }
//                System.out.println( xs.length-1 + ") " +(int)(x0 + xs[xs.length-1]* scale) + " " + (int)(y0 -ys[xs.length-1] * scale) + "\n");
            }
        };
        frame.add(panel);
        frame.setVisible(true);
    }

    public Curve(){
        this(null,null, new int[]{0, 0, 300, 300});
    }

    public Curve(double[] xs, double[] ys){
        this(xs,ys, new int[]{0, 0, 300, 300});
    }

    public Curve(double[] xs, double[] ys, int[] border){
        setData(xs,ys);
        setBorder(border[0],border[1],border[2],border[3]);
        constructor();
    }

    public void setBorder(int x1,int y1,int x2,int y2) {
        border[0] = x1;
        border[1] = y1;
        border[2] = x2;
        border[3] = y2;
    }

    public void setData(double[] xs, double[] ys){
        this.xs = xs;
        this.ys = ys;
    }

    public static void main(String[] args) {
        double[] xs = new double[21];
        double[] ys = new double[21];
        double x= 0;
        for(int i = 0; i<xs.length;i++) {
            xs[i] = x;
            ys[i] = Math.sin(x);
//            System.out.println(xs[i] + " " + ys[i]);
            x+=2*Math.PI/(xs.length-1);
        }
        new Curve(xs,ys);
    }
}
