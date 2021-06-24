package Control;


import java.awt.*;

/**
 * @author Jonas Braus, Noah Kessinger
 */
public class Movable {

    public Vector2 position;
    public Vector2 scale;
    public DrawType drawType;
    public Color color;
    public String text;

    public Movable(Vector2 position, Vector2 scale, DrawType drawType, Color color)
    {
        this.position = position;
        this.scale = scale;
        this.drawType = drawType;
        this.color = color;
        this.text = "";
    }

    public Movable(Vector2 position, DrawType drawType, Color color)
    {
        this.position = position;
        this.scale = new Vector2(1, 1);
        this.drawType = drawType;
        this.color = color;
        this.text = "";
    }

    public Movable(Vector2 position, DrawType drawType, Color color, String text)
    {
        this.position = position;
        this.scale = new Vector2(1, 1);
        this.drawType = drawType;
        this.color = color;
        this.text = text;
    }
}
