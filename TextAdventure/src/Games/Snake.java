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
    private Vector2 lastPosition;
    private Movable text;
    private int length = 1;

    public Snake(Control control)
    {
        window = new GameWindow(new Vector2(800, 800), "Snake");

        //generate the grid
        for (int x = 0; x <= window.width; x += cellSize)
        {
            window.addMovable(new Movable(new Vector2(x, window.height / 2), new Vector2(1, window.height), DrawType.RectFilled, Color.black));
            width++;
        }
        for (int y = 0; y <= window.height; y += cellSize)
        {
            window.addMovable(new Movable(new Vector2(window.width / 2, y), new Vector2(window.width, 1), DrawType.RectFilled, Color.black));
            height++;
        }

        width--;
        height--;

        int randX = window.random(-1, 1);
        int randY = 0;
        if (randX == 0)
        {
            randY = window.randomNo0(-1, 1);
        }

        moveDirection = new Vector2(randX, randY);
        timeStep = window.time;

        addPart(cellToPosition(new Vector2(window.random(10, width - 10), window.random(10, height - 10))));
        apple = new Movable(cellToPosition(new Vector2(window.random(5, width - 5), window.random(5, height - 5))), new Vector2(cellSize - 1, cellSize - 1), DrawType.RectFilled, Color.red);
        window.addMovable(apple);

        text = new Movable(new Vector2(window.width / 2, 35), DrawType.Text, Color.blue, "" + length);
        window.addMovable(text);

        lastPosition = new Vector2(player.get(0).position.x, player.get(0).position.y);

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
        if (window.isKeyPressed(KeyCode.W) && moveDirection.y == 0)
        {
            moveDirection = new Vector2(0, -1);
        } else if (window.isKeyPressed(KeyCode.S) && moveDirection.y == 0)
        {
            moveDirection = new Vector2(0, 1);
        } else if (window.isKeyPressed(KeyCode.A) && moveDirection.x == 0)
        {
            moveDirection = new Vector2(-1, 0);
        } else if (window.isKeyPressed(KeyCode.D) && moveDirection.x == 0)
        {
            moveDirection = new Vector2(1, 0);
        }

        if (window.time - timeStep > 200)
        {
            move(moveDirection);
            timeStep = window.time;
            checkApple();

            if(player.get(0).position.x < 0 || player.get(0).position.y < 0 || player.get(0).position.x > cellToPosition(new Vector2(width, 0)).x || player.get(0).position.y > cellToPosition(new Vector2(0, height)).y)
            {
                window.close();
            }
        }
    }


    private void checkApple()
    {
        if (player.get(0).position.x == apple.position.x && player.get(0).position.y == apple.position.y)
        {
            Movable tempMov = new Movable(player.get(0).position, new Vector2(cellSize - 1, cellSize - 1), DrawType.RectFilled, new Color(123, 255, 28));
            player.add(tempMov);
            window.addMovable(tempMov);

            length += 1;
            text.text = "" + length;


            apple.position = cellToPosition(new Vector2(window.random(1, width - 2), window.random(1, height - 2)));
        }
    }

    private void move(Vector2 direction)
    {
        Vector2 mov = new Vector2(direction.x, direction.y);
        mov.multiply(cellSize);
        player.get(0).position.add(mov);

        if (player.size() > 1)
        {
            for (int i = player.size() - 1; i > 1; i--)
            {
                player.get(i).position = new Vector2(player.get(i - 1).position.x, player.get(i - 1).position.y);
            }

            player.get(1).position = lastPosition;

            for(int i = 1; i < player.size(); i++)
            {
                if(player.get(0).position.x == player.get(i).position.x && player.get(0).position.y == player.get(i).position.y)
                {
                    window.close();
                }
            }
        }

        lastPosition = new Vector2(player.get(0).position.x, player.get(0).position.y);
    }

    private void addPart(Vector2 position)
    {
        Movable tempMov = new Movable(position, new Vector2(cellSize - 1, cellSize - 1), DrawType.RectFilled, new Color(28, 255, 32));
        player.add(tempMov);
        window.addMovable(tempMov);
    }

    private Vector2 positionToCell(Vector2 position)
    {
        return new Vector2((int) (position.x / cellSize), (int) (position.y / cellSize));
    }

    private Vector2 cellToPosition(Vector2 cell)
    {
        Vector2 output = new Vector2(cell.x, cell.y);
        output.multiply(cellSize);
        output.add(new Vector2(cellSize / 2f, cellSize / 2f));

        return output;
    }
}
