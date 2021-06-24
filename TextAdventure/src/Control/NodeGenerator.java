package Control;

import GUI.GameWindow;
import Games.Pong;
import Games.Snake;
import Games.TicTacToe;

import java.util.Timer;
import java.util.TimerTask;

public class NodeGenerator {

    private Control control;

    public NodeGenerator(Control control) {
        this.control = control;
        onStart();
    }

    private void onStart() {

        Node en1, en2, en3, sn1, sn2, sn3, start, information;

        en1 = createNode("End Node 1");
        en2 = createNode("End Node 2");
        en3 = createNode("End Node 3");

        sn1 = createNode("Story Node 1", "Ende 1", "Ende 1", "Ende 2", "Ende 3", en1, en1, en2, en3);
        sn2 = createNode("Tic Tac Toe", "Ende 3", "Ende 3", "Ende 1", "Ende 2", en3, en3, en1, en2, new Runnable() {
            @Override
            public void run()
            {
                Snake snake = new Snake(control);
            }
        });
        sn3 = createNode("Pong", "Ende 3", "Ende 3", "Ende 1", "Ende 2", en3, en3, en1, en2, new Runnable() {
            @Override
            public void run()
            {
                Pong pong = new Pong(control);
            }
        });

        start = createNode("Start Node", "Pong", "Story Node 1", "Tic Tac Toe", "Ende 3", sn3, sn1, sn2, en3);
        information = createNode("Hallo ich bin eine Information ", "Weiter", start);
        control.setActiveNode(information);
    }

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

    public Node createNode(String nodeText) {
        Node n = new EndNode(nodeText, control);


        return n;
    }

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
