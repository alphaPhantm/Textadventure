package Control;

import jdk.incubator.vector.FloatVector;

import java.util.Vector;

public class Movable {

    public Vector2 position;
    public Vector2 scale;
    public DrawType drawType;

    public Movable(Vector2 position, Vector2 scale, DrawType drawType)
    {
        this.position = position;
        this.scale = scale;
        this.drawType = drawType;
    }

    public Movable(Vector2 position, DrawType drawType)
    {
        this.position = position;
        this.scale = new Vector2(1, 1);
        this.drawType = drawType;
    }



}
