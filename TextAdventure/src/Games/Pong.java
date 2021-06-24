package Games;

import Control.Control;
import GUI.GameWindow;

import Control.Control;
import Control.DrawType;
import Control.Movable;
import Control.Vector2;
import GUI.GameWindow;

import Control.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.exit;

/**
 * @author Noah Kessinger
 */
public class Pong {

    private GameWindow window;
    private Control control;
    private Movable player1, player2, ball, baseline, scorePlayer1, scorePlayer2;

    private int velocity;
    private Vector2 direction;
    private int scorePlayer1int, scorePlayer2int;

    public Pong(Control control){

        scorePlayer1int = 0;
        scorePlayer2int = 0;



        //create new GameWindow with Title "Pong"
        window = new GameWindow(new Vector2(800, 600), "Pong");
        this.control = control;

        //drawing base elemts
        player1 = new Movable(new Vector2(50, window.height / 2), new Vector2(30, 70), DrawType.RectFilled, Color.RED);
        player2 = new Movable(new Vector2(window.width - 50, window.height / 2), new Vector2(30, 70), DrawType.RectFilled, Color.BLUE);
        ball = new Movable(new Vector2(window.width / 2, window.height / 2), new Vector2(30, 30), DrawType.RectFilled, Color.BLACK);

        baseline = new Movable(new Vector2(window.width / 2, window.height / 2), new Vector2(3, window.height), DrawType.RectFilled, Color.GRAY);

        scorePlayer1int = 0;
        scorePlayer2int = 0;

        velocity = 1;
        direction = new Vector2(window.randomNo0(-1, 1), window.randomNo0(-1, 1));
        


        scorePlayer1 = new Movable(new Vector2(window.width / 2 - 60, 30), DrawType.Text, Color.GRAY, scorePlayer1int + "");
        scorePlayer2 = new Movable(new Vector2(window.width / 2 + 60, 30), DrawType.Text, Color.GRAY, scorePlayer2int + "");



        window.addMovable(scorePlayer1);
        window.addMovable(scorePlayer2);
        window.addMovable(baseline);
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
                        player1.position.y -= 2;
                    }
                }
                if (window.isKeyPressed(KeyCode.S)){
                    if (player1.position.y < window.height - (player1.scale.y /2)){
                        player1.position.y += 2;
                    }
                }

                

                scorePlayer1.text = scorePlayer1int + "";
                scorePlayer2.text = scorePlayer2int + "";
                ball.position.add(direction);

                if(ball.position.x < 0 + ball.scale.x / 2){
                    direction = new Vector2(window.randomNo0(0, 1), window.randomNo0(-1, 1));
                    ball.position = new Vector2(window.width, window.height);
                    scorePlayer2int++;
                    scorePlayer1int--;

                }

                if (ball.position.x > window.width - ball.scale.x / 2){
                    direction = new Vector2(window.randomNo0(-1, 0), window.randomNo0(-1, 1));
                    ball.position = new Vector2(window.width / 2, window.height / 2);
                    scorePlayer1int++;

                }


                if (ball.position.y > window.height - (ball.scale.y /2)){
                    direction = new Vector2(window.randomNo0(-1, 1), window.randomNo0(-1, 0));
                }
                if (ball.position.y < 0 + (ball.scale.y /2)){
                    direction = new Vector2(window.randomNo0(-1, 1), window.randomNo0(0, 1));
                }


                if (ball.position.x - (ball.scale.x / 2) == player1.position.x + (player1.scale.x / 2) && ((ball.position.y + (ball.scale.y / 2) > player1.position.y - (player1.scale.y / 2) && ball.position.y + (ball.scale.y / 2) < player1.position.y + (player1.scale.y / 2)) || (ball.position.y - (ball.scale.y / 2) < player1.position.y + (player1.scale.y / 2) && ball.position.y - (ball.scale.y / 2) > player1.position.y - (player1.scale.y / 2)))){
                    direction = new Vector2(window.randomNo0(0, 1), window.randomNo0(-1, 1));
                    
                }

                if (ball.position.x + (ball.scale.x / 2) == player2.position.x - (player1.scale.x / 2) && ((ball.position.y + (ball.scale.y / 2) > player2.position.y - (player2.scale.y / 2) && ball.position.y + (ball.scale.y / 2) < player2.position.y + (player2.scale.y / 2)) || (ball.position.y - (ball.scale.y / 2) < player2.position.y + (player2.scale.y / 2) && ball.position.y - (ball.scale.y / 2) > player2.position.y - (player2.scale.y / 2)))){
                    direction = new Vector2(window.randomNo0(-1, 0), window.randomNo0(-1, 1));
                    
                }


                if (ball.position.x > (window.width / 2) && player2.position.y < ball.position.y){
                    player2.position.y += 0.5;
                }
                if (ball.position.x > (window.width / 2) && player2.position.y > ball.position.y){
                    player2.position.y -= 0.5;
                }





            }
        };
        t.scheduleAtFixedRate(tt, 1, 4);


    }




}
