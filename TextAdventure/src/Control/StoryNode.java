package Control;

/**
 * @author Jonas Braus, Noah Kessinger
 */
public class StoryNode extends Node {

    /**
     * constructor for the StoryNode
     * @param edges
     * @param text
     * @param control
     */
    public StoryNode(Edge[] edges, String text, Control control) {

        super(edges, text, control);
    }

    /**
     * function that declares the entrance behaviour of the Node
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
    }
}
