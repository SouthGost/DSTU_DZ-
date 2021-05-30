package Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task6 extends JFrame {
    private Kubic kub = new Kubic();

    task6(){
        super();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        kub.setPreferredSize(new Dimension(50,50));
        panel1.add(kub);

        add(panel1);

        JButton throwButton = new JButton("Trow");
        throwButton.addActionListener(e -> {
            System.out.println(kub.kubThrow());
            kub.repaint();
        });
        add(throwButton,BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new task6();
    }
}


