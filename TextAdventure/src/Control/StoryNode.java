package Control;

/**
 * @author Jonas Braus, Noah Kessinger
 */
public class StoryNode extends Node {

    public StoryNode(Edge[] edges, String text, Control control) {

        super(edges, text, control);
    }

    @Override
    public void onEnter()
    {
        control.exitInfo();
        control.setOutputText(text);
        for(Edge e : edges)
        {
            e.onEnable();
        }
    }
}
