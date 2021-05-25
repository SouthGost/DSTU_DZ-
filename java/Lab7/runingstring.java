package Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class runingstring extends JPanel {

    private int pogx = 8, pogy = 25;
    private String strok;
    private String strok_now;
    private int nowSymbol=1;
    private Timer t;

    public void stopTimer(){
        t.stop();
    }

    public void startTimer(){
        t.start();
    }

    public void setStrok(String newStrok) {
        strok = newStrok;
        nowSymbol=1;
        strok_now = strok.substring(0,nowSymbol);
        repaint();
        t.start();
    }

    public runingstring(String newStrok) {
        super();
        setPreferredSize(new Dimension(400, 45));
        this.strok = newStrok;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                nowSymbol=1;
                strok_now = strok.substring(0,nowSymbol);
                repaint();
                t.start();
            }
        });
        strok_now = strok.substring(0,nowSymbol);

        t = new Timer( 50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                strok_now = strok.substring(0,nowSymbol);
                if(nowSymbol<strok.length()){
                    ++nowSymbol;
                } else {
                    t.stop();
                }
                if(nowSymbol<strok.length() && strok.charAt(nowSymbol) == ' ') ++nowSymbol;
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        Font font = new Font("Arial", 1, 12);
        FontMetrics fontMetrics = getFontMetrics(font);
        int message_width = fontMetrics.stringWidth(strok_now);
        int difference = 0;
        if (message_width>getWidth()-8){
            difference = message_width-(getWidth()-8);
        }
        g.drawString( strok_now, pogx-difference, pogy);//getHeight()/2

    }

}
