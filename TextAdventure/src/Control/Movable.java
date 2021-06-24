package Control;


import java.awt.*;

/**
 *
 * @author Jonas Braus, Noah Kessinger
 * The Movable class is a universal solution for all movable objects in game. It stores values like the objects position
 * Also it stores information for rendering on the screen.
 */
public class Movable {

    public Vector2 position;
    public Vector2 scale;
    public DrawType drawType;
    public Color color;
    public String text;

    /**
     * Constructor for a normal Movable object with all parameters
     * @param position
     * @param scale
     * @param drawType
     * @param color
     */
    public Movable(Vector2 position, Vector2 scale, DrawType drawType, Color color)
    {
        this.position = position;
        this.scale = scale;
        this.drawType = drawType;
        this.color = color;
        this.text = "";
    }

    /**
     * Constructor for a movable object, that uses default scale
     * @param position
     * @param drawType
     * @param color
     */
    public Movable(Vector2 position, DrawType drawType, Color color)
    {
        this.position = position;
        this.scale = new Vector2(1, 1);
        this.drawType = drawType;
        this.color = color;
        this.text = "";
    }

    /**
     * Constructor for movable text (string)
     * @param position
     * @param drawType
     * @param color
     * @param text
     */
    public Movable(Vector2 position, DrawType drawType, Color color, String text)
    {
        this.position = position;
        this.scale = new Vector2(1, 1);
        this.drawType = drawType;
        this.color = color;
        this.text = text;
    }
}
