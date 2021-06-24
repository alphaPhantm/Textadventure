package Control;

/**
 * @author Jonas Braus, Noah Kessinger
 * An Edge is a connection between two Nodes, that stores a text, that is shown on the selection buttons later
 */
public class Edge {

    public Node pointing;
    private String text;
    private Control control;
    private int index;

    /**
     * Constructor for the edge
     * @param pointing
     * @param text
     * @param control
     * @param index
     */
    public Edge(Node pointing, String text, Control control, int index)
    {
        this.control = control;
        this.pointing = pointing;
        this.text = text;
        this.index = index;
    }

    /**
     * Function that implements the behaviour of the Edge when it's got enabled
     */
    public void onEnable()
    {
        control.setButtonText(index, text);
    }

    /**
     * Function that implements the behaviour of the Edge, when it's activated
     */
    public void activate()
    {
        control.setActiveNode(pointing);
    }
}
