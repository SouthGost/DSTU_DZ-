package Lab6;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Point{
    double x;
    double y;


    public void printPoint(){
        System.out.println("x: "+x +" y: "+ y);
    }

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    public static void main(String[] args) {
        Random r = new Random();
        Point[] myPoints = new Point[201];
        Poligon poligon = new Poligon(3);
        double x = -10;
        for (int i=0;i<myPoints.length;++i){
            Point xy = new Point(x,f(x));
            myPoints[i] = xy;
            x+=0.1;
        }
        Function func1 = new Function(myPoints);
        poligon.addFunction(func1);
        x = -10;
        for (int i=0;i<myPoints.length;++i){
            Point xy = new Point(x,f2(x));
            myPoints[i] = xy;
            x+=0.1;
        }
        Function func2 = new Function(myPoints);
        poligon.addFunction(func2);
        x = -10;
        for (int i=0;i<myPoints.length;++i){
            Point xy = new Point(x,f3(x));
            myPoints[i] = xy;
            x+=0.1;
        }
        Function func3 = new Function(myPoints);
        poligon.addFunction(func3);
        poligon.showGrafics();
    }

    public static double f(double x){
        return x*x;
    }

    public static double f2(double x){
        return 5*x+3;
    }

    public static double f3(double x){
        return 15/(x);
    }
}

class Function{
    Point[] points;

    public void printFunction(){
        for(int i =0;i<points.length;++i){
            points[i].printPoint();
        }
        System.out.println();
    }

    public Function(Point[] points){
        int l = points.length;
        this.points = new Point[l];
        for (int i = 0;i<l;++i){
            this.points[i] = points[i];
        }
    }

}

class Poligon{
    int length;
    Function[] functions;

    private JFrame frame;
    private JPanel panel;

    public void showGrafics() {
        frame = new JFrame("task2");
        frame.setSize(500, 500);
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
                for(Function f:functions){
                    for(int i=0;i<f.points.length-1;i++){
                        g.drawLine((int)(x0 + f.points[i].x * scale), (int)(y0 - f.points[i].y * scale), (int)(x0 + f.points[i+1].x * scale), (int)(y0 - f.points[i+1].y * scale));
                    }
                }
            }
        };
        frame.add(panel);
        frame.setVisible(true);
    }

    public void printPoligon(){
        for(int i =0;i<length;i++){
            System.out.println("Functions"+i+":");
            functions[i].printFunction();
        }
    }

    public Poligon(int length){
        this.functions = new Function[length];
        this.length = 0;
    }

    public void addFunction(Function f){
        if(length < functions.length) {
            functions[length] = f;
            length+=1;
        }
    }
}
