package Lab7;

import javax.swing.*;
import java.awt.*;

public class task6 extends JFrame {
    private Kubic kub = new Kubic();

    task6(){
        super();

        add(kub);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new task6();
    }
}

class Kubic extends JPanel{
    private Color bgclr = Color.WHITE;
    private Color circlClr = Color.BLACK;
    private int circlSize = 1;
    private int val = 1;

    Kubic(){
        super();
    }

    @Override
    public void paint(Graphics g){
        
    }

}
