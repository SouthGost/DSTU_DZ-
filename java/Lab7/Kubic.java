package Lab7;

import javax.swing.*;
import java.awt.*;

public class Kubic extends JPanel {
    private Color bgclr = Color.WHITE;
    private Color circlClr = Color.BLACK;
    private int circlSize = 10;
    private int val = 1;

    Kubic(){
        super();
    }

    Kubic(boolean bool){
        super(bool);
    }

    Kubic(LayoutManager lom){
        super(lom);
    }

    Kubic(LayoutManager lom,boolean bool){
        super(lom, bool);
    }

    public int kubThrow(){
        val = (int)Math.ceil(Math.random()*6);
        return val;
    }

    public void setBgclr(Color bgclr) {
        this.bgclr = bgclr;
    }

    public void setCirclClr(Color circlClr) {
        this.circlClr = circlClr;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        int w = getWidth(), h= getHeight();
        g.setColor(bgclr);
        g.fillRect(0,0,w,h);
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(5));
        g.drawRect(0,0,w,h);
        g2.setStroke(new BasicStroke(1));
        g.setColor(circlClr);
        switch (val){
            case 1:
                g.fillOval(w/2-circlSize/2,h/2-circlSize/2,circlSize,circlSize);
                break;
            case 2:
                g.fillOval(w/4-circlSize/2,h/4-circlSize/2,circlSize,circlSize);
                g.fillOval(w*3/4-circlSize/2,h*3/4-circlSize/2,circlSize,circlSize);
                break;
            case 3:
                g.fillOval(w/4-circlSize/2,h/4-circlSize/2,circlSize,circlSize);
                g.fillOval(w/2-circlSize/2,h/2-circlSize/2,circlSize,circlSize);
                g.fillOval(w*3/4-circlSize/2,h*3/4-circlSize/2,circlSize,circlSize);
                break;
            case 4:
                g.fillOval(w/4-circlSize/2,h/4-circlSize/2,circlSize,circlSize);
                g.fillOval(w*3/4-circlSize/2,h/4-circlSize/2,circlSize,circlSize);
                g.fillOval(w/4-circlSize/2,h*3/4-circlSize/2,circlSize,circlSize);
                g.fillOval(w*3/4-circlSize/2,h*3/4-circlSize/2,circlSize,circlSize);
                break;
            case 5:
                g.fillOval(w/4-circlSize/2,h/4-circlSize/2,circlSize,circlSize);
                g.fillOval(w*3/4-circlSize/2,h/4-circlSize/2,circlSize,circlSize);
                g.fillOval(w/2-circlSize/2,h/2-circlSize/2,circlSize,circlSize);
                g.fillOval(w/4-circlSize/2,h*3/4-circlSize/2,circlSize,circlSize);
                g.fillOval(w*3/4-circlSize/2,h*3/4-circlSize/2,circlSize,circlSize);
                break;
            case 6:
                g.fillOval(w/4-circlSize/2,h/4-circlSize/2,circlSize,circlSize);
                g.fillOval(w*3/4-circlSize/2,h/4-circlSize/2,circlSize,circlSize);
                g.fillOval(w/4-circlSize/2,h/2-circlSize/2,circlSize,circlSize);
                g.fillOval(w*3/4-circlSize/2,h/2-circlSize/2,circlSize,circlSize);
                g.fillOval(w/4-circlSize/2,h*3/4-circlSize/2,circlSize,circlSize);
                g.fillOval(w*3/4-circlSize/2,h*3/4-circlSize/2,circlSize,circlSize);
                break;
        }
    }

}