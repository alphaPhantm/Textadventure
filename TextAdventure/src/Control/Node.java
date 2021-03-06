package Control;

/**
 * @author Jonas Braus, Noah Kessinger
 * Node Class that represents a story snippet in the text adventure
 */
public abstract class Node {

    //the edges the Node is pointing to
    protected Edge[] edges = new Edge[4];
    //the text that is shown on the the Node
    protected String text;
    //reference to the control class
    protected Control control;

    /**
     * Abstract Function that implements the entrance behaviour of a Node
     */
    public abstract void onEnter();

    /**
     * The Node constructor
     * @param edges
     * @param text
     * @param control
     */
    public Node(Edge[] edges, String text, Control control)
    {
        this.control = control;
        this.edges = edges;
        this.text = text;
    }
}
