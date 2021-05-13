package Control;

public class Edge {

    public Node pointing;
    private String text;
    private Control control;
    private int index;

    public Edge(Node pointing, String text, Control control, int index)
    {
        this.control = control;
        this.pointing = pointing;
        this.text = text;
        this.index = index;
    }

    public void onEnable()
    {
        control.setButtonText(index, text);
    }

    public void activate()
    {
        control.setActiveNode(pointing);
    }
}
