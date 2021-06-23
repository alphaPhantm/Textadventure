package GUI;

import Control.Movable;

import javax.swing.*;

public class GameWindow extends JFrame
{
    private Canvas canvas;

    public GameWindow(int width, int height, String title)
    {
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle(title);
        setVisible(true);

        canvas = new Canvas();
    }

    public void addMovable(Movable m)
    {
        canvas.addMovable(m);
    }

    public void removeMovable(Movable m)
    {
        canvas.removeMovable(m);
    }

    public void removeMovable(int index)
    {
        canvas.removeMovable(index);
    }
}
