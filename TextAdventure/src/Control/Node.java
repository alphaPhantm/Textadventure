package Control;

public abstract class Node {

    protected Edge[] edges = new Edge[4];
    protected String text;
    protected Control control;

    public abstract void onEnter();

    public Node(Edge[] edges, String text, Control control)
    {
        this.control = control;
        this.edges = edges;
        this.text = text;
    }
}
