package Games;

import Control.Control;
import GUI.GameWindow;

import Control.Control;
import Control.DrawType;
import Control.Movable;
import Control.Vector2;
import GUI.GameWindow;

import Control.KeyCode;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.exit;


public class Pong {

    private GameWindow window;
    private Control control;
    private Movable player1, player2, ball;

    private int velocity;
    private Vector2 direction;

    public Pong(Control control){

        //create new GameWindow with Title "Pong"
        window = new GameWindow(new Vector2(800, 600), "Pong");
        this.control = control;

        //drawing base elemts
        player1 = new Movable(new Vector2(50, window.height / 2), new Vector2(30, 70), DrawType.RectFilled, Color.RED);
        player2 = new Movable(new Vector2(window.width - 50, window.height / 2), new Vector2(30, 70), DrawType.RectFilled, Color.BLUE);
        ball = new Movable(new Vector2(window.width / 2, window.height / 2), new Vector2(30, 30), DrawType.RectFilled, Color.BLACK);


        window.addMovable(player1);
        window.addMovable(player2);
        window.addMovable(ball);

        velocity = 1;
        direction = new Vector2(window.randomNo0(-1, 1), window.randomNo0(-1, 1));

        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (window.isKeyPressed(KeyCode.W)){
                    if (player1.position.y > 0 + (player1.scale.y /2)){
                        player1.position.y -= 1;
                    }
                }
                if (window.isKeyPressed(KeyCode.S)){
                    if (player1.position.y < window.height - (player1.scale.y /2)){
                        player1.position.y += 1;
                    }
                }
                if (window.isKeyPressed(KeyCode.Up)){
                    if (player2.position.y > 0 + (player1.scale.y /2)){
                        player2.position.y -= 1;
                    }
                }
                if (window.isKeyPressed(KeyCode.Down)) {
                    if (player2.position.y < window.height - (player1.scale.y / 2)) {
                        player2.position.y += 1;
                    }
                }

                ball.position.add(direction);


                if (ball.position.x > window.width - (ball.scale.x /2)){
                    direction = new Vector2(window.randomNo0(-1, 0), window.randomNo0(-1, 1));
                }
                if (ball.position.x < 0 + (ball.scale.x /2)){
                    direction = new Vector2(window.randomNo0(0, 1), window.randomNo0(-1, 1));
                }
                if (ball.position.y > window.height - (ball.scale.y /2)){
                    direction = new Vector2(window.randomNo0(-1, 1), window.randomNo0(-1, 0));
                }
                if (ball.position.y < 0 + (ball.scale.y /2)){
                    direction = new Vector2(window.randomNo0(-1, 1), window.randomNo0(0, 1));
                }

                if (ball.position.x == player1.position.x && ball.position.y == player1.position.y){
                    direction = new Vector2(window.randomNo0(0, 1), window.randomNo0(-1, 1));
                }


            }
        };
        t.scheduleAtFixedRate(tt, 1, 1);


    }




}
