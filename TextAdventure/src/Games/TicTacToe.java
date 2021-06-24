package Games;

import Control.Control;
import Control.DrawType;
import Control.Movable;
import Control.Vector2;
import GUI.GameWindow;
import Control.KeyCode;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A class that implements the functionality for a simple 3x3 tic tac toe game
 * Only works with Control.Vector2 & GUI.GameWindow & (Control.Control)
 */
public class TicTacToe
{
    private int player = 0; //stores which player is on turn
    private GameWindow window;
    private int[][] cells = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}}; //array that stores if the cells are free, should store cell values later
    private Control control;
    private Vector2 bestCellAI = new Vector2(0, 0);
    private float delayTime;

    /**
     * Constructor
     *
     * @param control
     */
    public TicTacToe(Control control)
    {
        //create new GameWindow with Title "Tic Tac Toe"
        window = new GameWindow(new Vector2(400, 400), "Tic Tac Toe");
        this.control = control;

        //draw the grid lines of the tic tac toe game
        for (int x = 0; x <= window.width; x += window.width / 3)
        {
            window.addMovable(new Movable(new Vector2(x, window.height / 2), new Vector2(1, window.height), DrawType.RectFilled, Color.black));
        }

        for (int y = 0; y <= window.height; y += window.height / 3)
        {
            window.addMovable(new Movable(new Vector2(window.width / 2, y), new Vector2(window.width, 1), DrawType.RectFilled, Color.black));
        }

        //select a random player to begin
        player = (int)(Math.random() * 2);
        System.out.println(player);

        delayTime = window.time;

        //start updating the game
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

    /**
     * Function that converts a position on the game window to a cell position
     *
     * @param position
     * @return Vector2 with cell position
     */
    private Vector2 positionToCell(Vector2 position)
    {
        return new Vector2((int) (position.x / (window.width / 3)), (int) (position.y / (window.height / 3)));
    }

    /**
     * Function that converts a cell position to a position on the game window
     *
     * @param cell
     * @return Vector2 with game window position
     */
    private Vector2 cellToPosition(Vector2 cell)
    {
        //save the cellSize once
        float cellSizeX = window.width / 3;
        float cellSizeY = window.height / 3;

        Vector2 output = new Vector2(cell.x, cell.y);
        output.x *= cellSizeX;
        output.y *= cellSizeY;

        output.x += (cellSizeX / 2);
        output.y += (cellSizeY / 2);

        return output;
    }

    /**
     * Function that is called each internal timer cycle
     */
    private void update()
    {

        if (player == 0 && window.isMousePressed)
        {
            //set isMousePressed to false, in case the player still pressed the mouse button
            window.isMousePressed = false;

            //get the x, y value of the clicked cell
            int cellX = (int) positionToCell(window.mousePosition).x;
            int cellY = (int) positionToCell(window.mousePosition).y;

            //check if cell is still free
            if (cells[cellX][cellY] == 2)
            {
                //if it's player 0s turn
                //add the render object to the game window
                window.addMovable(new Movable(cellToPosition(new Vector2(cellX, cellY)), new Vector2(window.width / 3 - 80, window.height / 3 - 80), DrawType.Circle, Color.blue));
                //set the internal value of the cell
                cells[cellX][cellY] = 0;
                //check for win
                if (checkForWin(cells))
                {
                    //display the winner and close the game window
                    control.setOutputText("Player " + player + " won the game !");
                    window.close();

                }
                //it is the other players turn
                player = 1;
                if(checkForWin(cells))
                {
                    player = 2;
                }

                delayTime = window.time;

            }

        } else if (player == 1 && window.time - delayTime > 1000)
        {
            Vector2 cellPosition = nextCellPosition();
            int cellX = (int)cellPosition.x;
            int cellY = (int)cellPosition.y;
            window.addMovable(new Movable(cellToPosition(new Vector2(cellX, cellY)), new Vector2(window.width / 3 - 80, window.height / 3 - 80), DrawType.Cross, Color.red));
            cells[cellX][cellY] = 1;

            if(checkForWin(cells))
            {
                control.setOutputText("Player " + player + " won the game !");
                window.close();

            }

            player = 0;

            if(checkForWin(cells))
            {
                player = 2;
            }

            delayTime = window.time;
        }


        if (areCellsFull())
        {
            //display message "no winner !" and end the game
            control.setOutputText("No winner !");
            window.close();
        }
    }

    /**
     * Function that checks if a player has won the game
     *
     * @return won ?
     */
    private boolean checkForWin(int[][] cells)
    {
        for (int i = 0; i < 3; i++)
        {
            //check rows
            if (cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i] && cells[0][i] != 2)
            {
                return true;
            }
            //check columns
            if (cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2] && cells[i][0] != 2)
            {
                return true;
            }
        }
        //check diagonals
        if ((cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2] || cells[2][0] == cells[1][1] && cells[1][1] == cells[0][2]) && cells[1][1] != 2)
        {
            return true;
        }

        //return false if there was no win detected
        return false;
    }

    /**
     * Function that checks if there are still free cells
     *
     * @return full ?
     */
    private boolean areCellsFull()
    {
        //loop through the array and return false if any cell filled with 2 is found
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                if (cells[x][y] == 2)
                {
                    return false;
                }
            }
        }
        //if there was no cell with 2 was found return true
        return true;
    }

    private Vector2 nextCellPosition()
    {

        //create an instance of the cells array
        int[][] tempCells = new int[3][3];

        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                tempCells[x][y] = cells[x][y];
            }
        }

        //check if there is any win possibility or the enemies would win in next turn
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                if(tempCells[x][y] == 2)
                {
                    tempCells[x][y] = 1;
                    if(checkForWin(tempCells))
                    {
                        return new Vector2(x, y);
                    }
                    tempCells[x][y] = 0;
                    if(checkForWin(tempCells))
                    {
                        return new Vector2(x, y);
                    }

                    tempCells[x][y] = 2;
                }
            }
        }

        //else place the cross anywhere
        int randX = 0, randY = 0;

        while (true)
        {
            randX = (int)(Math.random() * 3);
            randY = (int)(Math.random() * 3);

            if(tempCells[randX][randY] == 2)
            {
                break;
            }
        }

        return new Vector2(randX, randY);
    }
}