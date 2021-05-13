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
        Node n1 = createNode(NodeType.EndNode, "Ende 1");
        Node n2 = createNode(NodeType.EndNode, "Ende 2");
        Node n3 = createNode(NodeType.EndNode, "Ende 3");
        Node n4 = createNode(NodeType.EndNode, "Ende 4");

        Node storyNode1 = createNode(NodeType.StoryNode, "Story 1 ...", "Ende 1", "Ende 2", "Ende 3", "Ende 4", n1, n2, n3, n4);

        Node start = createNode(NodeType.StoryNode, "Willkommen zu unserem Spiel", "Story 1", "Ende 2", "Ende 3", "Ende 4", storyNode1, n2, n3, n4);

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

    public Node createNode(NodeType type, String nodeText)
    {
        Node n;

        switch(type)
        {
            case EndNode:
                n = new EndNode(nodeText, control);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }

        return n;
    }
}
