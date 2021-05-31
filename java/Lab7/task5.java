package Lab7;

import javax.swing.*;
import java.awt.*;

public class task5 extends JPanel{
    private final myJLabel upperLabel = new myJLabel("Верх");
    private final myJLabel downLabel = new myJLabel("Низ");
    private final myJLabel centerLabel = new myJLabel("Центр");

    public task5(){
        setLayout(new BorderLayout());

        upperLabel.setFont(new Font("dialog",Font.BOLD | Font.ITALIC, 10));
        downLabel.setFont(new Font("dialog",Font.BOLD | Font.ITALIC, 10));
        centerLabel.setFont(new Font("dialog",Font.BOLD, 18));

        upperLabel.setHorizontalAlignment(SwingConstants.LEFT);
        downLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        centerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(upperLabel,BorderLayout.NORTH);
        add(downLabel,BorderLayout.SOUTH);
        add(centerLabel,BorderLayout.CENTER);
    }

    public task5(String textUp, String textCenter, String textDown){
        this();
        setUpperText(textUp);
        centerLabel.setText(textCenter);
        setDownText(textDown);
    }

    public task5(String textUp, String textCenter, String textDown, Color clr){
        this();
        setUpperText(textUp);
        centerLabel.setText(textCenter);
        setDownText(textDown);
        setBgcolor(clr);
    }

    public void setBgcolor(Color clr){
        upperLabel.setBgclr(clr);
        downLabel.setBgclr(clr);
        centerLabel.setBgclr(clr);
    }
    public void setUpperText(String text){
        upperLabel.setText(text);
    }

    public void setDownText(String text){
        downLabel.setText(text);
    }

    public String getCentrText(){
        return centerLabel.getText();
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
        bgclr = clr;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(bgclr);
        g.fillRect(0,0,getWidth(),getHeight());
        super.paint(g);
    }
}