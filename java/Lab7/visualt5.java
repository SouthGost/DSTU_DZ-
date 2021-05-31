package Lab7;

import javax.swing.*;
import java.awt.*;

public class visualt5 extends JFrame {

    public visualt5(){
        task5 pnl = new task5("Stroka","Otana","Stroka", Color.GREEN);

        add(pnl);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        pnl.setBgcolor(Color.RED);
    }

    public static void main(String[] args) {
        new visualt5();
    }

}
