package Control;

import java.util.concurrent.Callable;

/**
 * @author Jonas Braus, Noah Kessinger
 * The ActionNode is a type of Node that can run code on Enter. It is made for minigames in the Textadventure
 */
public class ActionNode extends Node {

    private Runnable run;

    /**
     * constructor of the ActionNode
     * @param edges
     * @param text
     * @param control
     * @param run
     */
    public ActionNode(Edge[] edges, String text, Control control, Runnable run) {

        super(edges, text, control);
        this.run = run;
    }

    /**
     * function that declares the enter behaviour of the ActionNode
     */
    @Override
    public void onEnter()
    {
        control.exitInfo();
        control.setOutputText(text);
        for(Edge e : edges)
        {
            e.onEnable();
        }
        run.run();

    }

}
