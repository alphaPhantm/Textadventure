package Control;

import java.util.concurrent.Callable;

public class ActionNode extends Node {

    private Runnable run;

    public ActionNode(Edge[] edges, String text, Control control, Runnable run) {

        super(edges, text, control);
        this.run = run;
    }

    @Override
    public void onEnter()
    {
        control.setOutputText(text);
        for(Edge e : edges)
        {
            e.onEnable();
        }
        run.run();

    }

}
