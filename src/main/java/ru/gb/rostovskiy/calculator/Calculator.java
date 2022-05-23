package ru.gb.rostovskiy.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private Double leftOperand;
    private String operation;
    private boolean start;

    final private int[] numberArray = {7, 8, 9, 4, 5, 6, 1, 2, 3, 0};

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setLayout(new BorderLayout()); // компановщик
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel display = new JLabel("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 18));
        display.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        add(display, BorderLayout.NORTH);

        final JPanel numberPanel = new JPanel();
        final GridLayout numberLayout = new GridLayout(4, 4, 10, 10);
        numberPanel.setLayout(numberLayout);

        ActionListener numberListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final JButton button = (JButton) e.getSource();
                String text = button.getText();
                String displayText = display.getText();
                if (".".equals(text) && display.getText().contains(".")) {
                    return;
                }
                if ("0".equals((displayText)) && !".".equals(text)) {
                    displayText = "";
                }
                if ("+/-".equals(text)) {
                    text = display.getText();
                    displayText = "-";

                }
                displayText += text;
                display.setText(displayText);
            }
        };

        ActionListener buttonListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String action = source.getText();
                Double rightOperand = Double.parseDouble(display.getText());

                if ("=".equals(action)) {
                    if (leftOperand != null) {
                        switch (operation) {
                            case "+":
                                display.setText(String.valueOf(leftOperand + rightOperand));
                                break;
                            case "-":
                                display.setText(String.valueOf(leftOperand - rightOperand));
                                break;
                            case "*":
                                display.setText(String.valueOf(leftOperand * rightOperand));
                                break;
                            case "/":
                                display.setText(String.valueOf(leftOperand / rightOperand));
                                break;
                        }
                        leftOperand = Double.parseDouble(display.getText());
                        operation = null;
                        start = true;
                    }
                    return;
                }
                if ("C".equals(action)) {
                    display.setText("0");
                    leftOperand = Double.parseDouble(display.getText());
                    start = true;
                    //rightOperand = null;
                } else if (leftOperand != null && !start) {
                    switch (action) {
                        case "+":
                            leftOperand += rightOperand;
                            break;
                        case "-":
                            leftOperand -= rightOperand;
                            break;
                        case "*":
                            leftOperand *= rightOperand;
                            break;
                        case "/":
                            leftOperand /= rightOperand;
                            break;
                    }
                }  else {
                    leftOperand = rightOperand;
                }
                operation = action;
                display.setText("0");
                start = false;
            }
        };

        for (int i : numberArray) {
            final JButton button = new JButton(String.valueOf(i));
            button.addActionListener(numberListener);
            numberPanel.add(button);
        }

        JButton pointButton = new JButton(".");
        pointButton.addActionListener(numberListener);

        JButton negativeButton = new JButton("+/-");
        negativeButton.addActionListener(numberListener);
        numberPanel.add(pointButton);
        numberPanel.add(negativeButton);

        final JPanel buttonPanel = new JPanel();
        final GridLayout buttonLayout = new GridLayout(2,4, 10, 10);
        buttonPanel.setLayout(buttonLayout);
        for (char c : "C+-*/=".toCharArray()) {
            JButton button = new JButton(String.valueOf(c));
            if (String.valueOf(c).equals("=")){
                button.setBackground(Color.getHSBColor(192, 28, 54));
            }
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }
        add(numberPanel);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Calculator();
    }
}
