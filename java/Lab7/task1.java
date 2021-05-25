package Lab7;

import javax.swing.*;
import java.awt.*;

public class task1 extends JFrame {
    private JComboBox<Integer> comboBox;
    private JLabel label;
    private JButton button;
    private JCheckBox checkBox;
    private JRadioButton radioButton;
    private JTable table;



    public task1() {
        super("Task 1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        //panel1.setBackground(Color.YELLOW);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));//new FlowLayout() //new BoxLayout(panel1, BoxLayout.Y_AXIS)

        Integer[] arr = new Integer[]{1,2,3,4,5};
        comboBox = new JComboBox<Integer>(arr);
        comboBox.setPreferredSize(new Dimension(100, 30));
        panel1.add(comboBox);

        label = new JLabel("ABOBA");
        panel1.add(label);

        button = new JButton("Click");
        panel1.add(button);

        checkBox = new JCheckBox("Yes",true);
        panel1.add(checkBox);

        radioButton = new JRadioButton("Yes 2.0", true);
        panel1.add(radioButton);

        String[] columnNames = {"Язык", "Автор", "Год"};
        String[][] data = {
                {"Си", "Деннис Ритчи", "1972"},
                {"C++", "Бьерн Страуструп", "1983"},
                {"Python", "Гвидо ван Россум", "1991"},
                {"Java", "Джеймс Гослинг", "1995"},
                {"JavaScript", "Брендон Айк", "1995"},
                {"C#", "Андерс Хейлсберг", "2001"},
                {"Scala","Мартин Одерски","2003"}
        };
        table = new JTable(data, columnNames);
        JScrollPane scroll = new JScrollPane(table);
        System.out.println();
        panel1.add(scroll);

        add(panel1, BorderLayout.NORTH);//, BorderLayout.WEST

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public static void main(String[] args) {
        new task1();
    }
}
