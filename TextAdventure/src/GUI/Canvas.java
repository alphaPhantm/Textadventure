package GUI;

import Control.DrawType;
import Control.Movable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {

    private Graphics2D g2d;
    private List<Movable> movables = new ArrayList<>();
    private List<DrawType> drawTypes = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g)
    {
        g2d = (Graphics2D) g;

        for(int i = 0; i < movables.size(); i++)
        {
            Movable m = movables.get(i);

            switch(drawTypes.get(i))
            {
                case RectFilled:
                    g2d.fillRect(m.position.x - m.scale.x / 2, m.position.y - m.scale.y, m.scale.x, m.scale.y);
                    break;
            }
        }
    }

    public void paintComponent(Movable object, DrawType drawType)
    {
        movables.add(object);
        drawTypes.add(drawType);
    }
}
