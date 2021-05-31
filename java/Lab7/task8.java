package Lab7;

import javax.swing.*;
import java.awt.*;

public class task8 extends JFrame{
    private JPanel panel1;
    private task5[] move = new task5[8];
    private JPanel inform = new JPanel();

    private int temp = 0;
    private int[] score = {0,0};
    private int[] position = {0,0};
    private JLabel[] JLSocre = {new JLabel(score[0]+""),new JLabel(score[1]+"")};

    public task8(){
        super();
        move[0] = new task5("Player 1","+20","Player 2");
        move[1] = new task5("","Try Again...","");
        move[2] = new task5("","-50","");
        move[3] = new task5("","Lost ALL","");
        move[4] = new task5("","+30","");
        move[5] = new task5("","+10","");
        move[6] = new task5("","-10","");
        move[7] = new task5("","Finish!","");

        setLayout(new GridLayout(3,3));

        move[0].setBgcolor(Color.GREEN);
        move[1].setBgcolor(Color.yellow);
        move[2].setBgcolor(Color.pink);
        move[7].setBgcolor(Color.ORANGE);
        move[3].setBgcolor(Color.RED);
        move[6].setBgcolor(Color.pink);
        move[5].setBgcolor(Color.CYAN);
        move[4].setBgcolor(Color.GREEN);

        add(move[0]);
        add(move[1]);
        add(move[2]);
        add(move[7]);
        add(inform);
        add(move[3]);
        add(move[6]);
        add(move[5]);
        add(move[4]);

        JPanel infPlayer1 = new JPanel();
        JPanel infPlayer2 = new JPanel();
        infPlayer1.setLayout(new BorderLayout());
        infPlayer2.setLayout(new BorderLayout());

        infPlayer1.add(new JLabel("Player 1"), BorderLayout.NORTH);
        infPlayer2.add(new JLabel("Player 2"), BorderLayout.NORTH);
        //-----------------
        JPanel trowPanel1 = new JPanel();
        JButton throwButton1 = new JButton("Trow");

        JPanel trowPanel2 = new JPanel();
        JButton throwButton2 = new JButton("Trow");

        JPanel kubPanel1 = new JPanel();
        trowPanel1.setLayout(new BorderLayout());
        kubPanel1.setLayout(new FlowLayout());

        Kubic kub1 = new Kubic();
        kub1.setPreferredSize(new Dimension(50,50));
        kubPanel1.add(kub1);

        trowPanel1.add(kubPanel1);

        throwButton1.addActionListener(e -> {
            int val = kub1.kubThrow();
            System.out.println(val);
            if (temp == 0){
                move[position[0]].setUpperText("");
            }else{
                move[position[1]].setDownText("");
            }
            position[temp] = (position[temp] + val) % 8;
            String action = move[position[temp]].getCentrText();
            switch (action){
                case "+20":
                    score[temp] += 20;
                    break;
                case "Try Again...":
                    break;
                case "-50":
                    score[temp] -= 50;
                    break;
                case "Lost ALL":
                    score[temp] = 0;
                    break;
                case "+30":
                    score[temp] += 30;
                    break;
                case "+10":
                    score[temp] += 10;
                    break;
                case "-10":
                    score[temp] -= 10;
                    break;
                case "Finish!":
                    score[temp] += 50;
                    trowPanel1.remove(throwButton1);
                    inform.add(new JLabel(score[0]>score[1] ? "Player 1 Win": score[0]<score[1] ? "Player 2 Win" : "Draw"));
                    break;
            }
            if (temp == 0){
                move[position[0]].setUpperText("Player 1");
            }else{
                move[position[1]].setDownText("Player 2");
            }
            JLSocre[temp].setText(score[temp]+"");
            JLSocre[temp].repaint();
            if(!(action == "Try Again..." || action == "Finish!")) {
                temp = (1 + temp) % 2;
                trowPanel1.remove(throwButton1);
                trowPanel2.add(throwButton2, BorderLayout.SOUTH);
            }

            kub1.repaint();
        });
        trowPanel1.add(throwButton1, BorderLayout.SOUTH);
        infPlayer1.add(trowPanel1);
        //---------------------------------------
        JPanel kubPanel2 = new JPanel();
        trowPanel2.setLayout(new BorderLayout());
        kubPanel2.setLayout(new FlowLayout());

        Kubic kub2 = new Kubic();
        kub2.setPreferredSize(new Dimension(50,50));
        kubPanel2.add(kub2);

        trowPanel2.add(kubPanel2);

        throwButton2.addActionListener(e -> {
            int val = kub2.kubThrow();
            System.out.println(val);
            if (temp == 0){
                move[position[0]].setUpperText("");
            }else{
                move[position[1]].setDownText("");
            }
            position[temp] = (position[temp] + val) % 8;
            String action = move[position[temp]].getCentrText();
            switch (action){
                case "+20":
                    score[temp] += 20;
                    break;
                case "Try Again...":
                    break;
                case "-50":
                    score[temp] -= 50;
                    break;
                case "Lost ALL":
                    score[temp] = 0;
                    break;
                case "+30":
                    score[temp] += 30;
                    break;
                case "+10":
                    score[temp] += 10;
                    break;
                case "-10":
                    score[temp] -= 10;
                    break;
                case "Finish!":
                    score[temp] += 50;
                    trowPanel2.remove(throwButton2);
                    inform.add(new JLabel(score[0]>score[1] ? "Player 1 Win": score[0]<score[1] ? "Player 2 Win" : "Draw"));
                    break;
            }
            if (temp == 0){
                move[position[0]].setUpperText("Player 1");
            }else{
                move[position[1]].setDownText("Player 2");
            }
            JLSocre[temp].setText(score[temp]+"");
            JLSocre[temp].repaint();
            if(!(action == "Try Again..." || action == "Finish!")) {
                temp = (1 + temp) % 2;
                trowPanel2.remove(throwButton2);
                trowPanel1.add(throwButton1, BorderLayout.SOUTH);
            }

            kub2.repaint();
        });
        infPlayer2.add(trowPanel2);
        //---------------------------------------
        JPanel scoreInf1 = new JPanel(new BorderLayout());
        JPanel scoreInf2 = new JPanel(new BorderLayout());

        scoreInf1.add(new JLabel("Score:"),BorderLayout.WEST);
        scoreInf2.add(new JLabel("Score:"),BorderLayout.WEST);

        scoreInf1.add(JLSocre[0],BorderLayout.EAST);
        scoreInf2.add(JLSocre[1],BorderLayout.EAST);


        infPlayer1.add(scoreInf1,BorderLayout.SOUTH);
        infPlayer2.add(scoreInf2,BorderLayout.SOUTH);

        inform.setLayout(new BorderLayout());

        inform.add(infPlayer1, BorderLayout.WEST);
        inform.add(infPlayer2,BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new task8();
    }
}
