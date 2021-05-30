package Lab7;

import javax.swing.*;
import java.awt.*;

public class task5 extends JFrame{
    private Font updownFont = new Font("dialog",Font.BOLD | Font.ITALIC, 10);
    private Font centrFont = new Font("dialog",Font.BOLD, 18);
    private myJLabel upperLabel = new myJLabel("Верх");
    private myJLabel downLabel = new myJLabel("Низ");
    private myJLabel centerLabel = new myJLabel("Центр");

    task5(){
        upperLabel.setFont(updownFont);
        downLabel.setFont(updownFont);
        centerLabel.setFont(centrFont);

        upperLabel.setHorizontalAlignment(SwingConstants.LEFT);
        downLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        centerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(upperLabel,BorderLayout.NORTH);
        add(downLabel,BorderLayout.SOUTH);
        add(centerLabel,BorderLayout.CENTER);

        upperLabel.setBgclr(Color.green);
        downLabel.setBgclr(Color.ORANGE);
        centerLabel.setBgclr(Color.blue);

        upperLabel.setForeground(Color.RED);
        downLabel.setForeground(Color.BLACK);
        centerLabel.setForeground(Color.pink);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new task5();
    }
}

class myJLabel extends JLabel{
    private Color bgclr = Color.white;

    myJLabel(String text){
        super(text);
    }


    myJLabel(){
        super();
    }


    public void setBgclr(Color clr) {
        this.bgclr = clr;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(bgclr);
        g.fillRect(0,0,getWidth(),getHeight());
        super.paint(g);
    }
}