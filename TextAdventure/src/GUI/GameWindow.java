package GUI;

import Control.Movable;
import Control.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.Timer;

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

    /**
     * Constructor
     * @param size
     * @param title
     */
    public GameWindow(Vector2 size, String title)
    {
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
}
