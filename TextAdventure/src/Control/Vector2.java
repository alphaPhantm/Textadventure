package Control;

public class Vector2 {

    public int x, y;

    public Vector2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2 multiply(int scalar)
    {
        return new Vector2(x * scalar, y * scalar);
    }

    public Vector2 add(Vector2 vector)
    {
        return new Vector2(x + vector.x, y + vector.y);
    }

}
