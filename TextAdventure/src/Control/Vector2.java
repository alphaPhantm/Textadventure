package Control;

/**
 * @author Jonas Braus, Noah Kessinger
 * This class represents a two dimensional vector
 */
public class Vector2 {

    public float x, y;

    /**
     * constructor for the vector
     * @param x
     * @param y
     */
    public Vector2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * function to multiply the vector by a scalar
     * @param scalar
     */
    public void multiply(float scalar)
    {
       x *= scalar;
       y *= scalar;
    }

    /**
     * function to add another vector to this vector
     * @param vector
     */
    public void add(Vector2 vector)
    {
        x += vector.x;
        y += vector.y;
    }


    /**
     * Override for the toString function (f.e. for System output)
     * @return
     */
    @Override
    public String toString()
    {
        return x + " " + y;
    }

}
