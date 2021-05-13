package GUI;

import Control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JTextArea outputField;
    private JButton buttons[] = new JButton[4];

    public GUI(Control control)
    {
        Font defaultFont = new Font("Arial", 0, 20);

        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Awakening");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttons[0] = new JButton();
        buttons[0].setBounds(10, 380, 360, 80);
        buttons[0].setContentAreaFilled(false);
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.activateEdge(0);
            }
        });
        add(buttons[0]);


        buttons[1] = new JButton();
        buttons[1].setBounds(10, 470, 360, 80);
        buttons[1].setContentAreaFilled(false);
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.activateEdge(1);
            }
        });
        add(buttons[1]);


        buttons[2] = new JButton();
        buttons[2].setBounds(390, 380, 360, 80);
        buttons[2].setContentAreaFilled(false);
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.activateEdge(2);
            }
        });
        add(buttons[2]);


        buttons[3] = new JButton();
        buttons[3].setBounds(390, 470, 360, 80);
        buttons[3].setContentAreaFilled(false);
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.activateEdge(3);
            }
        });
        add(buttons[3]);

        outputField = new JTextArea();
        outputField.setBounds(10, 10, 765, 350);
        outputField.setLineWrap(true);
        outputField.setFont(defaultFont);
        outputField.setEditable(false);
        add(outputField);

        setVisible(true);
    }

    public void setButtonText(int index, String text)
    {
        buttons[index].setText(text);
    }

    public void setOutputText(String text)
    {
        outputField.setText(text);
    }
}
