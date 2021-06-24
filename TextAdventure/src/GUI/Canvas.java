package GUI;

import Control.DrawType;
import Control.Movable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jonas Braus, Noah Kessinger
 * An extension of the JPanel that holds movable objects in a list, and draws them on the screen
 */
public class Canvas extends JPanel {

    private Graphics2D g2d;
    private List<Movable> movableList = new ArrayList<>();

    /**
     * Function with override for the JPanels paintComponent function. It draws all movables in the movables list
     * @param g
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g2d = (Graphics2D) g;

        //loop through each element in movable list
        for(int i = 0; i < movableList.size(); i++)
        {
            Movable m = movableList.get(i);

            //set the draw color to the color stored in the movable
            g2d.setColor(m.color);
            g2d.setStroke(new BasicStroke(2.5f));
            g2d.setFont(new Font("Arial", Font.PLAIN, 40));
            switch(m.drawType)
            {
                //check for the movables shape and draw it
                case RectFilled:
                    g2d.fillRect((int)(m.position.x - m.scale.x / 2), (int)(m.position.y - m.scale.y / 2), (int)m.scale.x, (int)m.scale.y);
                    break;
                case RectOutlined:
                    g2d.drawRect((int)(m.position.x - m.scale.x / 2), (int)(m.position.y - m.scale.y / 2), (int)m.scale.x, (int)m.scale.y);
                    break;
                case Circle:
                    g2d.drawOval((int)(m.position.x - m.scale.x / 2), (int)(m.position.y - m.scale.y / 2), (int)m.scale.x, (int)m.scale.y);
                    break;
                case Cross:
                    g2d.drawLine((int)(m.position.x - m.scale.x / 2), (int)(m.position.y - m.scale.y / 2), (int)(m.position.x + m.scale.x / 2), (int)(m.position.y + m.scale.y / 2));
                    g2d.drawLine((int)(m.position.x - m.scale.x / 2), (int)(m.position.y + m.scale.y / 2), (int)(m.position.x + m.scale.x / 2), (int)(m.position.y - m.scale.y / 2));
                    break;
                case Text:
                    g2d.drawString(m.text, m.position.x, m.position.y);
                    break;
            }
        }

        //refresh the painting area
        repaint();
    }

    /**
     * Function to add a movable
     * @param m
     */
    public void addMovable(Movable m)
    {
        movableList.add(m);
    }

    /**
     * Function to remove a movable
     * @param m
     */
    public void removeMovable(Movable m)
    {
        movableList.remove(m);
    }

    /**
     * Function to remove a movable by its index
     * @param index
     */
    public void removeMovable(int index)
    {
        removeMovable(index);
    }
}
