package Control;


import java.awt.*;

public class Movable {

    public Vector2 position;
    public Vector2 scale;
    public DrawType drawType;
    public Color color;

    public Movable(Vector2 position, Vector2 scale, DrawType drawType, Color color)
    {
        this.position = position;
        this.scale = scale;
        this.drawType = drawType;
        this.color = color;
    }

    public Movable(Vector2 position, DrawType drawType, Color color)
    {
        this.position = position;
        this.scale = new Vector2(1, 1);
        this.drawType = drawType;
        this.color = color;
    }



}
