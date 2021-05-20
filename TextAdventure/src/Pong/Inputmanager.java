package Pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Inputmanager implements KeyListener
{
    private boolean player1Up, player1Down;
    private boolean player2Up, player2Down;

    {
        player1Up = player1Down = player2Up = player2Down = false;
    }

    public boolean isPlayer1Up()
    {
        return player1Up;
    }

    public boolean isPlayer1Down()
    {
        return player1Down;
    }

    public boolean isPlayer2Up()
    {
        return player2Up;
    }

    public boolean isPlayer2Down()
    {
        return player2Down;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                player2Up = true;
                break;

            case KeyEvent.VK_DOWN:
                player2Down = true;
                break;

            case KeyEvent.VK_W:
                player1Up = true;
                break;

            case KeyEvent.VK_S:
                player1Down = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                player2Up = false;
                break;

            case KeyEvent.VK_DOWN:
                player2Down = false;
                break;

            case KeyEvent.VK_W:
                player1Up = false;
                break;

            case KeyEvent.VK_S:
                player1Down = false;
                break;
        }
    }
}
