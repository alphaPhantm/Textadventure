package Games;

import Control.Control;
import GUI.GameWindow;
import Control.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Snake
{
    private GameWindow window;
    private final int cellSize = 30;
    private int width = 0, height = 0;
    private ArrayList<Movable> player = new ArrayList<>();
    private Movable apple;
    private Vector2 moveDirection;
    private float timeStep = 0;

    public Snake(Control control)
    {
        window = new GameWindow(new Vector2(800, 800), "Snake");

        //generate the grid
        for (int x = 0; x <= window.width; x += cellSize)
        {
            window.addMovable(new Movable(new Vector2(x, window.height / 2), new Vector2(1, window.height), DrawType.RectFilled, Color.black));
            width++;
        }
        for(int y = 0; y <= window.height; y += cellSize)
        {
            window.addMovable(new Movable(new Vector2(window.width / 2, y), new Vector2(window.width, 1), DrawType.RectFilled, Color.black));
            height++;
        }

        int randX = window.random(-1, 1);
        int randY = 0;
        if(randX == 0)
        {
            randY = window.randomNo0(-1, 1);
        }

        moveDirection = new Vector2(randX, randY);
        System.out.println(moveDirection);
        timeStep = window.time;

        addPart(cellToPosition(new Vector2(window.random(5, width - 5), window.random(5, height - 5))));
        apple = new Movable(cellToPosition(new Vector2(window.random(5, width - 5), window.random(5, height - 5))), new Vector2(cellSize - 1, cellSize - 1), DrawType.RectFilled, Color.red);
        window.addMovable(apple);

        Timer t = new Timer();
        TimerTask tt = new TimerTask()
        {
            @Override
            public void run()
            {
                update();
            }
        };

        t.scheduleAtFixedRate(tt, 1, 1);
    }

    private void update()
    {
        if(window.time - timeStep > 1000)
        {
            move(moveDirection);
            timeStep = window.time;
        }
    }

    private void move(Vector2 direction)
    {
        Vector2 mov = new Vector2(direction.x, direction.y);
        mov.multiply(cellSize);
        player.get(0).position.add(mov);
    }

    private void addPart(Vector2 position)
    {
        Movable tempMov = new Movable(position, new Vector2(cellSize - 1, cellSize - 1), DrawType.RectFilled, Color.green);
        player.add(tempMov);
        window.addMovable(tempMov);
    }

    private Vector2 positionToCell(Vector2 position)
    {
        return new Vector2((int)(position.x / cellSize), (int)(position.y / cellSize));
    }

    private Vector2 cellToPosition(Vector2 cell)
    {
        Vector2 output = new Vector2(cell.x, cell.y);
        output.multiply(cellSize);
        output.add(new Vector2(cellSize / 2f, cellSize / 2f));

        return output;
    }
}
