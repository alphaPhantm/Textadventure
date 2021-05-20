package Pong;

import javax.swing.*;
import java.awt.*;

public class PongCanvas extends JPanel
{
    private Graphics2D g2d;
    private Player player1, player2;
    private Ball ball;

    public PongCanvas(Player player1, Player player2, Ball ball)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.ball = ball;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g2d = (Graphics2D) g;

        g2d.setColor(new Color(255, 0, 0));
        drawPlayer(player2.getPosX(), player2.getPosY());
        g2d.drawString(String.valueOf(player2.getPoints()), 700, 20);

        g2d.setColor(new Color(0, 0, 255));
        drawPlayer(player1.getPosX(), player1.getPosY());
        g2d.drawString(String.valueOf(player1.getPoints()), 100, 20);

        g2d.setColor(new Color(0, 0, 0));
        drawBall(ball.getPosX(), ball.getPosY());

        repaint();
    }

    private void drawPlayer(int x, int y)
    {
        g2d.fillRect(x - Player.playerWidth / 2, y - Player.playerHeight / 2, Player.playerWidth, Player.playerHeight);
    }

    private void drawBall(int x, int y)
    {
        g2d.fillRect(x - Ball.ballWidth / 2, y - Ball.ballWidth / 2, Ball.ballWidth, Ball.ballWidth);
    }
}
