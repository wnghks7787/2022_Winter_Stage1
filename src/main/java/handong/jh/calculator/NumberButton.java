package handong.jh.calculator;

import javax.swing.*;
import java.awt.*;

public class NumberButton extends JButton{

    JButton btn;

    public NumberButton() {
        setLayout(new FlowLayout());
        this.btn = new JButton();
    }
}
