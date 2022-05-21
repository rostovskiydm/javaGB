package ru.gb.rostovskiy.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Test window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 400, 400, 400);
        final JButton button1 = new JButton("Button #1");
        final JButton button2 = new JButton("Button #2");
        final JButton button3 = new JButton("Button #3");
        final JButton button4 = new JButton("Button #4");
        final JButton button5 = new JButton("Button #5");
        add(button1, BorderLayout.NORTH);
        add(button2, BorderLayout.SOUTH);
        add(button3, BorderLayout.WEST);
        add(button4, BorderLayout.EAST);
        add(button5, BorderLayout.CENTER);
        // ctrl+alt+v - создали отдельную переменную для многократного испольхзования листенера кнопок
        ActionListener btnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                 button1.setText("Нажал на кнопку 5");
//                button2.setText("Нажал на кнопку 5");
//                button3.setText("Нажал на кнопку 5");
//                button4.setText("Нажал на кнопку 5");
                final JButton button = (JButton) e.getSource();
                final String text = button.getText();

                button1.setText("Нажал на кнопку " + button.getText());
                button2.setText("Нажал на кнопку " + button.getText());
                button3.setText("Нажал на кнопку " + button.getText());
                button4.setText("Нажал на кнопку " + button.getText());
            }
        };
        button1.addActionListener(btnListener);
        button2.addActionListener(btnListener);
        button3.addActionListener(btnListener);
        button4.addActionListener(btnListener);
        button5.addActionListener(btnListener);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyWindow();
    }
}
