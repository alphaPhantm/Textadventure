package Pong;

public class Ball
{
    private int posX, posY;
    private byte direction; //0 = right top, 1 = right bot || 2 = left top, 3 = left bot

    public static int ballWidth = 10;
    public static int ballSlower = 1;

    {
        posX = posY = 300;
        direction = 0;
    }

    public int getPosY()
    {
        return posY;
    }

    public int getPosX()
    {
        return posX;
    }

    public void setDirection(byte direction)
    {
        this.direction = direction;
    }

    public byte getDirection()
    {
        return direction;
    }

    public void moveDirection()
    {
        switch (direction)
        {
            case 0:
                posY--;
                posX++;
                break;
            case 1:
                posY++;
                posX++;
                break;
            case 2:
                posY--;
                posX--;
                break;
            case 3:
                posY++;
                posX--;
                break;
            default:
                posY++;
                posX++;
                System.out.println("A invalid direction value was passed");
        }
    }

    public void resetPosition()
    {
        posX = posY = 300;
    }

    public boolean isCollidingPlayer(Player player1, Player player2)
    {
        if ((posX - ballWidth / 2 < player1.getPosX() + Player.playerWidth / 2 &&
                posY + ballWidth / 2 > player1.getPosY() - Player.playerHeight && posY - ballWidth / 2 < player1.getPosY() + Player.playerHeight)
        || posX + ballWidth / 2 > player2.getPosX() - Player.playerWidth / 2 &&
                posY + ballWidth / 2 > player2.getPosY() - Player.playerHeight && posY - ballWidth / 2 < player2.getPosY() + Player.playerHeight)
        {
            return true;
        }

        return false;
    }

    public boolean isCollidingBorder()
    {
        if (posY - ballWidth / 2< 0 || posY + ballWidth / 2 > 560)
        {
            return true;
        }
        return false;
    }

    public byte isGoal(Player player1, Player player2)
    {
        if(posX - ballWidth / 2 < player1.getPosX() + Player.playerWidth / 2 - 1)
        {
            return 2;
        }
        else if(posX + ballWidth / 2 > player2.getPosX() - Player.playerWidth / 2 + 1)
        {
            return 1;
        }

        return 0;
    }

}
