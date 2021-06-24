package Control;

import GUI.GameWindow;
import Games.Pong;
import Games.Snake;
import Games.TicTacToe;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Jonas Braus, Noah Kessinger
 * The Class that is responsable for generating the Node Mesh.
 */
public class NodeGenerator {

    private Control control;

    /**
     * the constructor for the Node Generator
     * @param control
     */
    public NodeGenerator(Control control) {
        this.control = control;
    }

    /**
     * function to create a StoryNode
     * @param nodeText
     * @param edge1Text
     * @param edge2Text
     * @param edge3Text
     * @param edge4Text
     * @param pointing1
     * @param pointing2
     * @param pointing3
     * @param pointing4
     * @return
     */
    public Node createNode(String nodeText, String edge1Text, String edge2Text, String edge3Text, String edge4Text, Node pointing1, Node pointing2, Node pointing3, Node pointing4) {
        Node n;
        Edge[] edges = new Edge[4];


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

        for (int i = 0; i < 4; i++) {
            edges[i] = new Edge(pointingNode[i], edgeText[i], control, i);
        }


        n = new StoryNode(edges, nodeText, control);


        return n;
    }

    /**
     * function to create an ActionNode
     * @param nodeText
     * @param edge1Text
     * @param edge2Text
     * @param edge3Text
     * @param edge4Text
     * @param pointing1
     * @param pointing2
     * @param pointing3
     * @param pointing4
     * @param run
     * @return
     */
    public Node createNode(String nodeText, String edge1Text, String edge2Text, String edge3Text, String edge4Text, Node pointing1, Node pointing2, Node pointing3, Node pointing4, Runnable run) {
        Node n;
        Edge[] edges = new Edge[4];


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

        for (int i = 0; i < 4; i++) {
            edges[i] = new Edge(pointingNode[i], edgeText[i], control, i);
        }


        n = new ActionNode(edges, nodeText, control, run);

        return n;
    }

    /**
     * function to create an EndNode
     * @param nodeText
     * @return
     */
    public Node createNode(String nodeText) {
        Node n = new EndNode(nodeText, control);


        return n;
    }

    /**
     * function to create an InfoNode
     * @param nodeText
     * @param edge1Text
     * @param pointing1
     * @return
     */
    public Node createNode(String nodeText, String edge1Text, Node pointing1){

        Node n;
        Edge[] edges = new Edge[1];

        Node[] pointingNode = new Node[1];
        pointingNode[0] = pointing1;


        String[] edgeText = new String[1];
        edgeText[0] = edge1Text;


        edges[0] = new Edge(pointingNode[0], edgeText[0], control, 4);



        n = new InformationNode(edges, nodeText, control);

        return n;
    }
}
