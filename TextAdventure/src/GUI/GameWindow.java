package GUI;

import Control.KeyCode;
import Control.Movable;
import Control.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * This class is an extension of the JFrame especially for little mini games
 */
public class GameWindow extends JFrame
{
    private Canvas canvas;
    public boolean isMousePressed = false;
    public Vector2 mousePosition = new Vector2(0, 0);
    public float width;
    public float height;
    public long time, startTime;

    private boolean keyW, keyS, keyA, keyD, keyUp, keyDown, keyLeft, keyRight, keySpace;

    /**
     * Constructor
     * @param size
     * @param title
     */
    public GameWindow(Vector2 size, String title)
    {
        keyW = keyS = keyA = keyD = keyUp = keyDown = keyLeft = keyRight = keySpace = false;

        //set some default values for the JFrame
        setSize((int)size.x, (int)size.y);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle(title);
        setVisible(true);

        //create a canvas object
        canvas = new Canvas();

        //add the canvas to the Frame
        add(canvas);

        //get with and height of the game windows content area
        width = getContentPane().getWidth();
        height = getContentPane().getHeight();

        //add a mouseListener to the Frame
        addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                //set isMousePressed to true when mouse is pressed
                isMousePressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                //set isMousePressed to false when mouse is released
                isMousePressed = false;
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });

        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {

            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_W:
                        keyW = true;
                        break;
                    case KeyEvent.VK_S:
                        keyS = true;
                        break;
                    case KeyEvent.VK_A:
                        keyA = true;
                        break;
                    case KeyEvent.VK_D:
                        keyD = true;
                        break;
                    case KeyEvent.VK_UP:
                        keyUp = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        keyDown = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        keyLeft = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        keyRight = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        keySpace = true;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_W:
                        keyW = false;
                        break;
                    case KeyEvent.VK_S:
                        keyS = false;
                        break;
                    case KeyEvent.VK_A:
                        keyA = false;
                        break;
                    case KeyEvent.VK_D:
                        keyD = false;
                        break;
                    case KeyEvent.VK_UP:
                        keyUp = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        keyDown = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        keyLeft = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        keyRight = false;
                        break;
                    case KeyEvent.VK_SPACE:
                        keySpace = false;
                        break;
                }
            }
        });

        startTime = System.currentTimeMillis();

        //start looping the update function
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
     * Function that updates all important values
     */
    private void update()
    {
        //get the current mouse position in relation to the frame
        mousePosition.x = MouseInfo.getPointerInfo().getLocation().x - getX() - (getWidth() - width);
        mousePosition.y = MouseInfo.getPointerInfo().getLocation().y - getY() - (getHeight() - height);

        time = System.currentTimeMillis() - startTime;
    }

    /**
     * Function that adds an object to the render list
     * @param m
     */
    public void addMovable(Movable m)
    {
        //calls add movable function from the canvas
        canvas.addMovable(m);
    }

    /**
     * function that removes an object from the render list
     * @param m
     */
    public void removeMovable(Movable m)
    {
        //calls the remove movable function from the canvas
        canvas.removeMovable(m);
    }

    /**
     * function that removes an object form the render list by its index
     * @param index
     */
    public void removeMovable(int index)
    {
        //calls the remove movable function from the canvas
        canvas.removeMovable(index);
    }

    public boolean isKeyPressed(KeyCode key)
    {
        switch(key)
        {
            case W:
                return keyW;

            case S:
                return keyS;

            case A:
                return keyA;

            case D:
                return keyD;

            case Up:
                return keyUp;

            case Down:
                return keyDown;

            case Left:
                return keyLeft;

            case Right:
                return keyRight;

            case Space:
                return keySpace;

        }

        return false;
    }

    public void close()
    {
        WindowEvent event = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(event);
    }

    public int random(int min, int max)
    {
        min--;
        min++;
        return ((int)(Math.random() * (max - min)) + min);
    }
}
