package Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

public class Curve {
    protected double[] xs;
    protected double[] ys;
    protected final int[] border = {0,0,0,0};


    public void Curvepaint(Graphics g,int w, int h, int scale) {
        int x0 = w/2;
        int y0 = h/2;
        for(int i=0; i< xs.length-2;i++){
//                    System.out.println( i + ") " +(int)(x0 + xs[i]* scale) + " " + (int)(y0 -ys[i] * scale));
            if( (xs[i] >= border[0] && xs[i] <= border[2] && ys[i] >= border[1] && ys[i] <= border[3]) && (xs[i+1] >= border[0] && xs[i+1] <= border[2] && ys[i+1] >= border[1] && ys[i+1] <= border[3]) ) {
                g.drawLine((int)(x0 + xs[i] * scale), (int)(y0 - ys[i] * scale), (int)(x0 + xs[i + 1] * scale), (int)(y0 - ys[i + 1] * scale));
            }
        }
//                System.out.println( xs.length-1 + ") " +(int)(x0 + xs[xs.length-1]* scale) + " " + (int)(y0 -ys[xs.length-1] * scale) + "\n");
    }

    public Curve(){
        this(null,null, new int[]{-30, -100, 30, 100});
    }

    public Curve(double[] xs, double[] ys){
        this(xs,ys, new int[]{-30, -100, 30, 100});
    }

    public Curve(double[] xs, double[] ys, int[] border){
        setData(xs,ys);
        setBorder(border[0],border[1],border[2],border[3]);
    }

    public void setBorder(int x1,int y1,int x2,int y2) {
        border[0] = x1;
        border[1] = y1;
        border[2] = x2;
        border[3] = y2;
    }

    public void setData(double[] x, double[] y){
        xs = new double[x.length];
        ys = new double[y.length];
        for(int i =0; i<x.length; i++) {
            xs[i]=x[i];
            ys[i]=y[i];
        }
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