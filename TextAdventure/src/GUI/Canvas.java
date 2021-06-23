package GUI;

import Control.DrawType;
import Control.Movable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {

    private Graphics2D g2d;
    private List<Movable> movableList = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g)
    {
        g2d = (Graphics2D) g;

        for(Movable m : movableList)
        {
            switch(m.drawType)
            {
                case RectFilled:
                    g2d.fillRect(m.position.x - m.scale.x / 2, m.position.y - m.scale.y / 2, m.scale.x, m.scale.y);
                    break;
                case RectOutlined:
                    g2d.drawRect(m.position.x - m.scale.x / 2, m.position.y - m.scale.y / 2, m.scale.x, m.scale.y);
                    break;
            }
        }

        repaint();
    }

    public void addMovable(Movable m)
    {
        movableList.add(m);
    }

    public void removeMovable(Movable m)
    {
        movableList.remove(m);
    }

    public void removeMovable(int index)
    {
        removeMovable(index);
    }
}
