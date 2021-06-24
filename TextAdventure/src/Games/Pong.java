package Games;

import Control.Control;
import GUI.GameWindow;

import Control.Control;
import Control.DrawType;
import Control.Movable;
import Control.Vector2;
import GUI.GameWindow;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Pong {

    private GameWindow window;
    private Control control;
    private Movable player1, player2, ball;

    public Pong(Control control){

        //create new GameWindow with Title "Pong"
        window = new GameWindow(new Vector2(800, 600), "Pong");
        this.control = control;

        //drawing base elemts
        player1 = new Movable(new Vector2(10, window.height / 2), new Vector2(30, 70), DrawType.RectFilled, Color.GREEN);
        player2 = new Movable(new Vector2(window.width - 10, window.height / 2), new Vector2(30, 70), DrawType.RectFilled, Color.GREEN);


        window.addMovable(player1);
        window.addMovable(player2);




    }

}
