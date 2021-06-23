package Control;

public class Vector2 {

    public float x, y;

    public Vector2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2 multiply(float scalar)
    {
        return new Vector2(x * scalar, y * scalar);
    }

    public Vector2 add(Vector2 vector)
    {
        return new Vector2(x + vector.x, y + vector.y);
    }

    @Override
    public String toString()
    {
        return x + " " + y;
    }

}
