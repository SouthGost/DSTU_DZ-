package Lab7;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class task3 extends JFrame {
    private int pogx = 8, pogy = 30;
    private ArrayList<circl> circls = new ArrayList<>();
    private Timer t;
    private JButton addButton;
    private JButton stopButton;
    private runingstring runstr;

    public task3() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400); //    138
        JPanel panel1 = new JPanel(){
            @Override
            public void paint(Graphics g){
                super.paint(g);
                g.drawLine(0, 0, getWidth(), 0);
            }
        };
        panel1.setLayout(new FlowLayout());
        panel1.setPreferredSize(new Dimension(0, 70));

        addButton = new JButton("+1 Круг");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(circls.size()<10) {
                    circls.add(new circl(getWidth() - 16, getHeight() - panel1.getPreferredSize().height - 38));
                    repaint();
                } else{
                    runstr.setStrok("В окне находиться максимальное колличество шаров");
                }
            }
        });

        stopButton = new JButton("Пауза");
        stopButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(stopButton.getText() == "Пауза"){
                    t.stop();
                    stopButton.setText("Пуск");
                }else{
                    t.start();
                    stopButton.setText("Пауза");
                }
            }
        });

        runstr = new runingstring("Веселые шары");

        panel1.add(addButton);
        panel1.add(stopButton);
        panel1.add(runstr);
        add(panel1, BorderLayout.SOUTH);

        t = new Timer( 100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int w = getWidth();
                int h = getHeight()-panel1.getPreferredSize().height;
                for (circl cir : circls) {
                    cir.x += cir.movex;
                    cir.y += cir.movey;
                    if (cir.x > w - cir.len - 16) {
                        cir.x = w - cir.len - 16;
                        cir.movex *= -1;
                    } else if (cir.x < 0) {
                        cir.x = 0;
                        cir.movex *= -1;
                    }
                    if (cir.y > h - cir.len - 38) {
                        cir.y = h - cir.len - 38;
                        cir.movey *= -1;
                    } else if (cir.y < 0) {
                        cir.y = 0;
                        cir.movey *= -1;
                    }
                }
                repaint();
            }
        });
        setVisible(true);
        t.start();
        runstr.startTimer();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.drawLine(0, getHeight()-50, getWidth(), getHeight()-50);
        for (circl cir : circls) {
            g.setColor(cir.color);
            g.fillOval(cir.x + pogx, cir.y + pogy, cir.len, cir.len);
        }
    }
    public static void main(String[] args) {
        new task3();
    }
}

class circl{
    public int x=0, y=0;
    public int movex = 3, movey = 3;
    public int len = 100;
    public Color color;

    public static Color[] anycolor = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.magenta};

    circl(){
        color= anycolor[(int)(Math.random()*7)];
    }

    circl(int borderx, int bordery){
        x=(int)Math.round(Math.random()*(borderx-100));
        y=(int)Math.round(Math.random()*(bordery-100));
        movex = movey = 1+(int)Math.round(Math.random()*4);
        for(int i =0;i< (int)Math.round(Math.random()); i++){
            movex *= -1;
        }
        for(int i =0;i< (int)Math.round(Math.random()); i++){
            movey *= -1;
        }
        color= anycolor[(int)(Math.random()*7)];
    }
}
