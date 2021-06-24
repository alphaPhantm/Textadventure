package Games;

import Control.Control;
import GUI.GameWindow;
import Control.*;

import java.awt.*;

public class Snake
{
    private GameWindow window;
    private final int cellSize = 30;
    private int width, height;

    public Snake(Control control)
    {
        window = new GameWindow(new Vector2(800, 800), "Snake");

        //generate the grid
        for (int x = 0; x <= window.width; x += cellSize)
        {
            window.addMovable(new Movable(new Vector2(x, window.height / 2), new Vector2(1, window.height), DrawType.RectFilled, Color.black));
        }
        for(int y = 0; y <= window.height; y += cellSize)
        {
            window.addMovable(new Movable(new Vector2(window.width / 2, y), new Vector2(window.width, 1), DrawType.RectFilled, Color.black));
        }
    }
}
