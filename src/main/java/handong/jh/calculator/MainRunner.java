package handong.jh.calculator;

import javax.swing.*;
import java.awt.*;

public class MainRunner extends JFrame {

    static final int BTN_SIZE = 70;

    public static void main(String[] args) {

        JFrame frame = new JFrame("TEST");
        frame.setSize(350, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        addZeroButton(frame);
        addNumberButton(frame);
        makeLabel(frame, "4");
        frame.setVisible(true);
    }

    static void addZeroButton(JFrame frame)
    {
        int width, height;
        width = 20;
        height = frame.getHeight() - BTN_SIZE - 50;

        NumberButton btn = new NumberButton();

        btn.setText(String.valueOf(0));
        btn.setBounds(width, height, 140, 70);
        frame.getContentPane().add(btn);
        btn.setFont(btn.getFont().deriveFont(40.0f));
    }
    static void addNumberButton(JFrame frame)
    {
        int width, height;

        width = 20;
        height = frame.getHeight() - BTN_SIZE - 120;

        NumberButton[] btn = new NumberButton[9];

        for(int i = 0 ; i < 9 ; i++)
        {
            btn[i] = new NumberButton();
            btn[i].setText(String.valueOf(i + 1));
            btn[i].setBounds(width, height, 70, 70);
            frame.getContentPane().add(btn[i]);
            btn[i].setFont(btn[i].getFont().deriveFont(40.0f));

            width += 70;
            if((i + 1) % 3 == 0)
            {
                height -= BTN_SIZE;
                width = 20;
            }
        }
    }

    static void makeLabel(JFrame frame, String x)
    {
        int width, height;
        width = 20;
        height = 30;
        JLabel label = new JLabel("0");
        label.setOpaque(true);
        label.setBackground(Color.GRAY);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(label.getFont().deriveFont(40.0f));

        label.setBounds(width, height, frame.getWidth() - 40, 70);
        frame.getContentPane().add(label);
    }
}