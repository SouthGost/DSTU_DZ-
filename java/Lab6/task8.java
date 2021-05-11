package Lab6;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class task8 extends JFrame {

    private int pogx = 8, pogy = 45;
    private String[] stroks;
    private String strok;
    private int nowStrok = 0, nowSymbol=1;


    private Timer t;
    public task8(String[] stroks) {
        this.stroks = stroks;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)screenSize.getWidth()/2,400); //    138
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int newStrok = (int)Math.round(Math.random()*(stroks.length-1));
                nowStrok = newStrok == nowStrok ? (newStrok+1)%stroks.length : newStrok;
                nowSymbol=1;
                strok = stroks[nowStrok].substring(0,nowSymbol);
                repaint();
            }
        });
        strok = stroks[nowStrok].substring(0,nowSymbol);
        t = new Timer( 100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int w = getWidth();
                int h = getHeight();
                strok = stroks[nowStrok].substring(0,nowSymbol);
                if(nowSymbol<stroks[nowStrok].length()) ++nowSymbol;
                if(nowSymbol<stroks[nowStrok].length() && stroks[nowStrok].charAt(nowSymbol) == ' ') ++nowSymbol;
                repaint();
            }
        });
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        Font font = new Font("Arial", 1, 12);
        FontMetrics fontMetrics = getFontMetrics(font);
        int message_width = fontMetrics.stringWidth(strok);
        int difference = 0;
        if (message_width>getWidth()-8){
            difference = message_width-(getWidth()-8);
        }
        g.drawString( strok, pogx-difference, getHeight()/2);

    }

    public static void main(String[] args) {
        String[] stroks = {"Вижу тебя в чате по кд прессуют. Могу тебя дефать от хейтеров (пасты, троллинг, спам — мой конек). Цена простая — одна сабка. Или можешь дальше терпеть, дело твое.",
        "Заходит улитка в бар и говорит: -Виски со льдом -Извините, но мы не обслуживаем улиток и бармен выкинул ее за дверь. Через неделю улитка снова приходит в бар и спрашивает: -На*** ты это сделал?",
        "Happy star wars today everyone. Today is also my birthday and because it is my birthday i get introduce you to my gilfriend who is amaizing. -Hi gise. i am Britni."};
        new task8(stroks).setVisible(true);
    }
}
