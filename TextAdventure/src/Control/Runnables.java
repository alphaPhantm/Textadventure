package Control;

import Pong.Game;

import java.util.Timer;
import java.util.TimerTask;

public class Runnables {

    public void runPong() {
        Game game = new Game();
        game.start();

        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                game.update();
            }
        };
        t.scheduleAtFixedRate(tt, 1, 2);
    }
}
