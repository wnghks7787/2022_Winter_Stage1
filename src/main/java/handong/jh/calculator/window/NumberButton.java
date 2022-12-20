package handong.jh.calculator.window;

import javax.swing.*;
import java.awt.*;

public class NumberButton extends JButton{

    JButton btn;

    public NumberButton(String num)
    {
        setLayout(new FlowLayout());
        btn = new JButton(num);
        btn.setBackground(Color.BLUE);
        btn.setBounds(10, 10, 50, 50);
//        btn.setText(num);
    }
}
