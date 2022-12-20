package handong.jh.calculator;

import handong.jh.calculator.window.NumberButton;

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

        addButton(frame);
//        JButton btn5 = new JButton("5");
//        NumberButton btn5 = new NumberButton("5");
//        btn5.setBounds(100, 100, 20, 30);
//        frame.getContentPane().add(btn5);

//        frame.pack();
        frame.setVisible(true);
    }

    static void addButton(JFrame frame)
    {
        int width, height;

        width = 20;
        height = frame.getHeight() - BTN_SIZE - 50;

        for(int i = 0 ; i < 9 ; i++)
        {

            JButton btn = new JButton(String.valueOf(i + 1));

            btn.setBounds(width, height, 70, 70);
            frame.getContentPane().add(btn);

            width += 70;
            if((i + 1) % 3 == 0)
            {
                height -= BTN_SIZE;
                width = 20;
            }
        }
    }
}