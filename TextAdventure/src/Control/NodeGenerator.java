package Control;

public class NodeGenerator {

    private Control control;

    public NodeGenerator(Control control)
    {
        this.control = control;
        onStart();
    }

    private void onStart()
    {
        Node en1, en2, en3, sn1, sn2, start;

        en1 = createNode("End Node 1");
        en2 = createNode("End Node 2");
        en3 = createNode("End Node 3");

        sn1 = createNode(NodeType.StoryNode, "Story Node 1", "Ende 1", "Ende 1", "Ende 2", "Ende 3", en1, en1, en2, en3);
        sn2 = createNode(NodeType.StoryNode, "Story Node 2", "Ende 3", "Ende 3", "Ende 1", "Ende 2", en3, en3, en1, en2);

        start = createNode(NodeType.StoryNode, "Start Node", "Ende 1", "Story Node 1", "Story Node 2", "Ende 3", en1, sn1, sn2, en3);

        control.setActiveNode(start);
    }

    public Node createNode(NodeType type, String nodeText, String edge1Text, String edge2Text, String edge3Text, String edge4Text, Node pointing1, Node pointing2, Node pointing3, Node pointing4)
    {
        Node n;
        Edge[] edges = new Edge[4];

        if(type == NodeType.StoryNode || type == NodeType.ActionNode)
        {
            Node[] pointingNode = new Node[4];
            pointingNode[0] = pointing1;
            pointingNode[1] = pointing2;
            pointingNode[2] = pointing3;
            pointingNode[3] = pointing4;

            String[] edgeText = new String[4];
            edgeText[0] = edge1Text;
            edgeText[1] = edge2Text;
            edgeText[2] = edge3Text;
            edgeText[3] = edge4Text;

            for(int i = 0; i < 4; i++)
            {
                edges[i] = new Edge(pointingNode[i], edgeText[i], control, i);
            }
        }

        switch(type)
        {
            case StoryNode:
                n = new StoryNode(edges, nodeText, control);
                break;
            case ActionNode:
                n = new ActionNode(edges, nodeText, control);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }

        return n;
    }

    public Node createNode(String nodeText)
    {
        Node n = new EndNode(nodeText, control);


        return n;
    }
}