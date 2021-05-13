package Control;

public class ActionNode extends Node {

    public ActionNode(Edge[] edges, String text, Control control) {

        super(edges, text, control);
    }

    @Override
    public void onEnter()
    {
        control.setOutputText(text);
        for(Edge e : edges)
        {
            e.onEnable();
        }
    }
}
