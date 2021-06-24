package Control;

/**
 * @author Jonas Braus, Noah Kessinger
 * A single node, that is responsable for story snippets that only tell you an information. You dont have to do or decide anything.
 */
public class InformationNode extends Node {

    /**
     * Constructor for the information Node
     * @param edges
     * @param text
     * @param control
     */
    public InformationNode(Edge[] edges, String text, Control control) {

        super(edges, text, control);
    }

    /**
     * Function that implements the entrance behaviour of the node
     */
    @Override
    public void onEnter()
    {
        control.initInfo();
        control.setOutputText(text);
        edges[0].onEnable();

    }
}