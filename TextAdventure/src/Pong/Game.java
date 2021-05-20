package Pong;

public class Game
{
    private Player player1, player2;
    private Inputmanager inputmanager;
    private PongGUI gui;
    private Ball ball;
    private int cnt = 0, pID;

    public void start()
    {
        pID = 0;
        player1 = new Player();
        player1.setPosX(50);
        player2 = new Player();
        player2.setPosX(750);
        inputmanager = new Inputmanager();
        ball = new Ball();
        gui = new PongGUI(inputmanager, player1, player2, ball);
        gui.create();
    }

    public void update()
    {
        if(inputmanager.isPlayer1Up())
            player1.moveUp();


        if(inputmanager.isPlayer1Down())
            player1.moveDown();


        if(inputmanager.isPlayer2Up())
            player2.moveUp();


        if(inputmanager.isPlayer2Down())
            player2.moveDown();


        if(ball.isCollidingBorder())
        {
            switch(ball.getDirection())
            {
                case 0:
                    ball.setDirection((byte)1);
                    break;
                case 1:
                    ball.setDirection((byte)0);
                    break;
                case 2:
                    ball.setDirection((byte)3);
                    break;
                case 3:
                    ball.setDirection((byte)2);
                    break;
            }
        }

        if(ball.isCollidingPlayer(player1, player2))
        {
            switch(ball.getDirection())
            {
                case 2:
                    ball.setDirection((byte)0);
                    break;
                case 3:
                    ball.setDirection((byte)1);
                    break;
                case 0:
                    ball.setDirection((byte)2);
                    break;
                case 1:
                    ball.setDirection((byte)3);
            }
        }

        if(ball.isGoal(player1, player2) > 0)
        {
            if(ball.isGoal(player1, player2) == 1)
                player1.increasePoints();

            if(ball.isGoal(player1, player2) == 2)
                player2.increasePoints();

            ball.resetPosition();
        }


        if(cnt >= Ball.ballSlower)
        {
            ball.moveDirection();
            cnt = 0;
        }


        cnt++;
    }
}
