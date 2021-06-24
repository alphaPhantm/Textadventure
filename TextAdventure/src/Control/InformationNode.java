package Control;

public class InformationNode extends Node {

    public InformationNode(Edge[] edges, String text, Control control) {

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
        control.initInfo();
    }
}