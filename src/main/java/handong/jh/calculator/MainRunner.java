package handong.jh.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainRunner extends JFrame {


    static final int BTN_SIZE = 70;

    static String labelNumber = "0";
    static String addNumber;
    static JLabel label = new JLabel(labelNumber);
    static boolean flag = false;
    static boolean opFlag = false;
    static boolean checkOp = false;
    static boolean checkPoint = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyCalc");
        frame.setSize(330, 530);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        Calculator c = new Calculator();

        addOperatorButton(frame);
        addZeroButton(frame);
        addNumberButton(frame);
        addPointButton(frame);
        addClearButton(frame);
        addEqualButton(frame, c);
        makeLabel(frame);

        addHexButton(frame);
        addBinButton(frame);
        frame.setVisible(true);
    }

    static void addZeroButton(JFrame frame)
    {
        int x, y;
        x = 20;
        y = frame.getHeight() - BTN_SIZE - 50;

        NumberButton btn = new NumberButton();

        btn.setText(String.valueOf(0));
        btn.setBounds(x, y, BTN_SIZE * 2, BTN_SIZE);
        frame.getContentPane().add(btn);
        btn.setFont(btn.getFont().deriveFont(40.0f));

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = String.valueOf(btn.numValue);

                if (labelNumber.equals("0") || flag)
                    labelNumber = addNumber;
                else
                    labelNumber += addNumber;

                label.setText(labelNumber);
                flag = false;
                checkOp = false;
            }
        });
    }

    static void addNumberButton(JFrame frame)
    {
        int x, y;

        x = 20;
        y = frame.getHeight() - BTN_SIZE - 120;

        NumberButton[] btn = new NumberButton[9];

        for(int i = 0 ; i < 9 ; i++)
        {
            btn[i] = new NumberButton();
            btn[i].setText(String.valueOf(i + 1));
            btn[i].numValue = i + 1;
            btn[i].setBounds(x, y, BTN_SIZE, BTN_SIZE);
            frame.getContentPane().add(btn[i]);
            btn[i].setFont(btn[i].getFont().deriveFont(40.0f));

            x += 70;
            if((i + 1) % 3 == 0)
            {
                y -= BTN_SIZE;
                x = 20;
            }
        }
        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = String.valueOf(btn[0].numValue);

                if(labelNumber.equals("0") || flag)
                    labelNumber = addNumber;
                else
                    labelNumber += addNumber;

                label.setText(labelNumber);
                flag = false;
                checkOp = false;
            }
        });
        btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = String.valueOf(btn[1].numValue);

                if(labelNumber.equals("0") || flag)
                    labelNumber = addNumber;
                else
                    labelNumber += addNumber;

                label.setText(labelNumber);
                flag = false;
                checkOp = false;
            }
        });
        btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = String.valueOf(btn[2].numValue);

                if(labelNumber.equals("0") || flag)
                    labelNumber = addNumber;
                else
                    labelNumber += addNumber;

                label.setText(labelNumber);
                flag = false;
                checkOp = false;
            }
        });
        btn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = String.valueOf(btn[3].numValue);

                if(labelNumber.equals("0") || flag)
                    labelNumber = addNumber;
                else
                    labelNumber += addNumber;

                label.setText(labelNumber);
                flag = false;
                checkOp = false;
            }
        });

        btn[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = String.valueOf(btn[4].numValue);

                if(labelNumber.equals("0") || flag)
                    labelNumber = addNumber;
                else
                    labelNumber += addNumber;

                label.setText(labelNumber);
                flag = false;
                checkOp = false;
            }
        });

        btn[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = String.valueOf(btn[5].numValue);

                if(labelNumber.equals("0") || flag)
                    labelNumber = addNumber;
                else
                    labelNumber += addNumber;

                label.setText(labelNumber);
                flag = false;
                checkOp = false;
            }
        });

        btn[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = String.valueOf(btn[6].numValue);

                if(labelNumber.equals("0") || flag)
                    labelNumber = addNumber;
                else
                    labelNumber += addNumber;

                label.setText(labelNumber);
                flag = false;
                checkOp = false;
            }
        });
        btn[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = String.valueOf(btn[7].numValue);

                if(labelNumber.equals("0") || flag)
                    labelNumber = addNumber;
                else
                    labelNumber += addNumber;

                label.setText(labelNumber);
                flag = false;
                checkOp = false;
            }
        });
        btn[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = String.valueOf(btn[8].numValue);

                if(labelNumber.equals("0") || flag)
                    labelNumber = addNumber;
                else
                    labelNumber += addNumber;

                label.setText(labelNumber);
                flag = false;
                checkOp = false;
            }
        });
    }

    static void addPointButton(JFrame frame)
    {
        int x, y;
        x = 160;
        y = frame.getHeight() - BTN_SIZE - 50;

        NumberButton btn = new NumberButton();

        btn.setText(".");
        btn.operator = ".";
        btn.setBounds(x, y, BTN_SIZE, BTN_SIZE);
        frame.getContentPane().add(btn);
        btn.setFont(btn.getFont().deriveFont(40.0f));

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!checkPoint)
                {
                    addNumber = String.valueOf(btn.operator);

                    labelNumber += addNumber;
                    label.setText(labelNumber);

                    checkPoint = true;
                }
            }
        });
    }

    static void addOperatorButton(JFrame frame)
    {
        int x, y;

        x = BTN_SIZE * 3 + 20;
        y = frame.getHeight() - BTN_SIZE * 2 - 50;

        NumberButton[] btn = new NumberButton[9];

        for(int i = 0 ; i < 4 ; i++) {
            btn[i] = new NumberButton();

            switch (i) {
                case 0 -> btn[i].operator = "+";
                case 1 -> btn[i].operator = "-";
                case 2 -> btn[i].operator = "*";
                case 3 -> btn[i].operator = "/";
            }

            btn[i].setText(btn[i].operator);
            btn[i].setBounds(x, y, BTN_SIZE, BTN_SIZE);
            frame.getContentPane().add(btn[i]);
            btn[i].setFont(btn[i].getFont().deriveFont(40.0f));

            y -= BTN_SIZE;
        }

        // + 연산자
        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = btn[0].operator;

                if(!opFlag)
                {
                    if (checkOp)
                        labelNumber = labelNumber.substring(0, labelNumber.length() - 1);

                    if (!labelNumber.equals("0"))
                        labelNumber += addNumber;

                    label.setText(labelNumber);
                    flag = false;
                    checkOp = true;
                    checkPoint = false;
                }
            }
        });
        // - 연산자
        btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = btn[1].operator;

                if (!opFlag)
                {

                    if (checkOp)
                        labelNumber = labelNumber.substring(0, labelNumber.length() - 1);

                    if (!labelNumber.equals("0"))
                        labelNumber += addNumber;
                    else
                        labelNumber = addNumber;

                    label.setText(labelNumber);
                    flag = false;
                    checkOp = true;
                    checkPoint = false;
                }
            }
        });
        // * 연산자
        btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = btn[2].operator;

                if(!opFlag)
                {
                    if (checkOp)
                        labelNumber = labelNumber.substring(0, labelNumber.length() - 1);

                    if (!labelNumber.equals("0"))
                        labelNumber += addNumber;

                    label.setText(labelNumber);
                    flag = false;
                    checkOp = true;
                    checkPoint = false;
                }
            }
        });
        // / 연산자
        btn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber = btn[3].operator;

                if(!opFlag)
                {
                    if (checkOp)
                        labelNumber = labelNumber.substring(0, labelNumber.length() - 1);

                    if (!labelNumber.equals("0"))
                        labelNumber += addNumber;

                    label.setText(labelNumber);
                    flag = false;
                    checkOp = true;
                    checkPoint = false;
                }
            }
        });
    }

    static void addClearButton(JFrame frame)
    {
        int x, y;
        x = 20;
        y = frame.getHeight() - 50 - (BTN_SIZE * 5);

        NumberButton btn = new NumberButton();

        btn.setText("C");
        btn.operator = "C";
        btn.setBounds(x, y, BTN_SIZE, BTN_SIZE);
        frame.getContentPane().add(btn);
        btn.setFont(btn.getFont().deriveFont(40.0f));

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelNumber = "0";
                label.setText(labelNumber);
                flag = false;
                opFlag = false;
                checkPoint = false;
            }
        });
    }

    static void addEqualButton(JFrame frame, Calculator c)
    {
        int x, y;
        x = 20 + (BTN_SIZE * 3);
        y = frame.getHeight() - 50 - BTN_SIZE;

        NumberButton btn = new NumberButton();

        btn.setText("=");
        btn.operator = "=";
        btn.setBounds(x, y, BTN_SIZE, BTN_SIZE);
        frame.getContentPane().add(btn);
        btn.setFont(btn.getFont().deriveFont(40.0f));

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String calcStr = c.Calculation(labelNumber);
                labelNumber = calcStr;
                label.setText(labelNumber);

                flag = true;
            }
        });
    }

    static void addHexButton(JFrame frame)
    {
        int x, y;
        x = 20 + BTN_SIZE;
        y = frame.getHeight() - 50 - BTN_SIZE * 5;

        NumberButton btn = new NumberButton();


        btn.setBackground(Color.orange);
        btn.setText("HEX");
        btn.setBounds(x, y, BTN_SIZE, BTN_SIZE);
        frame.getContentPane().add(btn);
        btn.setFont(btn.getFont().deriveFont(20.0f));

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!opFlag)
                {
                    int num = Integer.parseInt(labelNumber);
                    labelNumber = Integer.toHexString(num);
                    label.setText(labelNumber);

                    flag = true;
                    opFlag = true;
                }
            }
        });
    }

    static void addBinButton(JFrame frame)
    {
        int x, y;
        x = 20 + BTN_SIZE * 2;
        y = frame.getHeight() - 50 - BTN_SIZE * 5;

        NumberButton btn = new NumberButton();


        btn.setBackground(Color.orange);
        btn.setText("Bin");
        btn.setBounds(x, y, BTN_SIZE, BTN_SIZE);
        frame.getContentPane().add(btn);
        btn.setFont(btn.getFont().deriveFont(20.0f));

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!opFlag)
                {
                    int num = Integer.parseInt(labelNumber);
                    labelNumber = Integer.toBinaryString(num);
                    label.setText(labelNumber);

                    flag = true;
                    opFlag = true;
                }
            }
        });
    }

    static void makeLabel(JFrame frame)
    {
        int width, height;
        width = 20;
        height = 30;

        label.setOpaque(true);
        label.setBackground(Color.GRAY);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(label.getFont().deriveFont(40.0f));

        label.setBounds(width, height, frame.getWidth() - 40, 70);
        frame.getContentPane().add(label);
    }
}