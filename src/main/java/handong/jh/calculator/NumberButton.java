package handong.jh.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends JButton{

    JButton btn;
    int numValue = 0;
    String operator = "";
    public static boolean active = true;

    public NumberButton() {
        setLayout(new FlowLayout());
        this.btn = new JButton();
    }
}
