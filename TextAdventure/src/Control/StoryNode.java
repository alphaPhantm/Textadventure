package Control;

public class StoryNode extends Node {

    public StoryNode(Edge[] edges, String text, Control control) {

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
