package Pong;

public class Player
{
    public static int playerWidth = 20;
    public static int playerHeight = 90;

    private int posY, posX;
    private int points;

    {
        posY = 300;
        points = 0;
    }

    public void setPosX(int posX)
    {
        this.posX = posX;
    }

    public int getPosY()
    {
        return posY;
    }

    public void moveUp()
    {
        if(posY > playerHeight / 2)
            posY --;
    }

    public void moveDown()
    {
        if(posY < 560 - playerHeight / 2)
            posY ++;
    }

    public int getPosX()
    {
        return posX;
    }

    public int getPoints()
    {
        return points;
    }

    public void increasePoints()
    {
        points++;
    }
}
