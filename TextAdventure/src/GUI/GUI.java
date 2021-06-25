package GUI;

import Control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Jonas Braus, Noah Kessinger
 */
public class GUI extends JFrame {

    private JTextArea outputField;
    private JButton buttons[] = new JButton[5];

    /**
     * Buildign The Main GUI with the Base Items.
     * @param control
     */
    public GUI(Control control)
    {
        Font defaultFont = new Font("Arial", 0, 20);

        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Awakening");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        Initialisation of the 4 decition Buttons
         */
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


        buttons[4] = new JButton();
        buttons[4].setBounds(10, 380, 750, 170);
        buttons[4].setContentAreaFilled(false);
        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.activateEdge(0);
            }
        });
        add(buttons[4]);




        /*
        Generating the Output field. In wich the story will be.
         */
        outputField = new JTextArea();
        outputField.setBounds(10, 10, 765, 350);
        outputField.setFont(new Font("Arial", Font.PLAIN, 100));
        outputField.setLineWrap(true);
        outputField.setFont(defaultFont);
        outputField.setEditable(false);
        add(outputField);

        setVisible(true);
    }

    /**
     * Funktion to set The text of a Button.
     * @param index
     * @param text
     */
    public void setButtonText(int index, String text)
    {
        buttons[index].setText(text);
    }

    /**
     * Set the visibility of the Button to false.
     * @param index
     */
    public void hideButtons(int index)
    {
        buttons[index].setVisible(false);
    }

    /**
     * Set the visibility of the Button to true.
     * @param index
     */
    public void showButtons(int index)
    {
        buttons[index].setVisible(false);
    }

    /**
     * funktion to set the Story text on or JTextArea.
     * @param text
     */
    public void setOutputText(String text)
    {
        outputField.setText(text);
    }

    /**
     * Initialisation of the InfoNode. Hiding the Normal Buttons.
     */
    public void initInfo(){
        buttons[4].setVisible(true);
        for (int i = 0; i < 4; i++) {
            buttons[i].setVisible(false);
        }
    }

    /**
     * Close the InfoNode and show the Buttons.
     */
    public void exitInfo(){
        buttons[4].setVisible(false);
        for (int i = 0; i < 4; i++) {
            buttons[i].setVisible(true);
        }
    }
}
