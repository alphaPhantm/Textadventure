package Pong;

import javax.swing.*;

public class PongGUI
{
    private JFrame jframe;
    private PongCanvas canvas;
    private Inputmanager inputmanager;
    private Player player1, player2;
    private Ball ball;

    public PongGUI(Inputmanager inputmanager, Player player1, Player player2, Ball ball)
    {
        this.inputmanager = inputmanager;
        this.player1 = player1;
        this.player2 = player2;
        this.ball = ball;
    }

    public void create()
    {
        jframe = new JFrame();
        jframe.setSize(800, 600);
        jframe.setTitle("Pong");
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        canvas = new PongCanvas(player1, player2, ball);
        jframe.add(canvas);
        jframe.addKeyListener(inputmanager);

        jframe.setVisible(true);
    }

}
