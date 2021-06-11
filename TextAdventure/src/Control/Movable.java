package Control;

import jdk.incubator.vector.FloatVector;

import java.util.Vector;

public class Movable {

    public Vector2 position;
    public Vector2 scale;

    public Movable(Vector2 position, Vector2 scale)
    {
        this.position = position;
        this.scale = scale;
    }

    public Movable(Vector2 position)
    {
        this.position = position;
        this.scale = new Vector2(1, 1);
    }
}
