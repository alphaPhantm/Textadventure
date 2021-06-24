package Games;

import Control.Control;
import GUI.GameWindow;
import Control.*;

public class Snake
{
    private GameWindow window;

    public Snake(Control control)
    {
        window = new GameWindow(new Vector2(800, 800), "Snake");
    }
}
