package Control;

public class Vector2 {

    public float x, y;

    public Vector2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void multiply(float scalar)
    {
       x *= scalar;
       y *= scalar;
    }

    public void add(Vector2 vector)
    {
        x += vector.x;
        y += vector.y;
    }

    public void normalize()
    {
        double magnitude = Math.sqrt(x * x + y * y);
        x /= magnitude;
        y /= magnitude;
    }

    @Override
    public String toString()
    {
        return x + " " + y;
    }

}
