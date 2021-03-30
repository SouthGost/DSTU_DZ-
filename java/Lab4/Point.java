package Lab4;

import java.util.Random;

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
        Point[] myPoints = new Point[101];
        Poligon poligon = new Poligon(3);
        double x = -5;
        for (int i=0;i<myPoints.length;++i){
            Point xy = new Point(x,f(x));
            myPoints[i] = xy;
            x+=0.1;
        }
        x = -5;
        for (int i=0;i<myPoints.length;++i){
            Point xy = new Point(x,f2(x));
            myPoints[i] = xy;
            x+=0.1;
        }
        Function func2 = new Function(myPoints);
        poligon.addFunction(func2);
        poligon.printPoligon();
        x = -5;
        for (int i=0;i<myPoints.length;++i){
            Point xy = new Point(x,f3(x));
            myPoints[i] = xy;
            x+=0.1;
        }
        Function func3 = new Function(myPoints);
        poligon.addFunction(func3);
        poligon.printPoligon();
    }

    public static double f(double x){
        return x*x;
    }

    public static double f2(double x){
        return 5*x+3;
    }

    public static double f3(double x){
        return x*x*x*-1;
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
