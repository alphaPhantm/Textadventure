package Control;

import GUI.GameWindow;
import Games.Pong;
import Games.Snake;
import Games.TicTacToe;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Jonas Braus, Noah Kessinger
 */
public class NodeGenerator {

    private Control control;

    public NodeGenerator(Control control) {
        this.control = control;
        onStart();
    }

    private void onStart() {

        Node en1, en2, en3, sn1, sn2, sn3, start, information, capter1_1, capter1_2, capter1_3;

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

        capter1_3 = createNode("König: „Krieger, bestimmt kannst du dir denken, dass ich dich nicht nur einlud, um mit mir am Tisch zu essen und Gespräche über Gott und die Welt zu führen. Ich habe einen Auftrag für dich, du bist der beste Krieger des Königreiches Raavensteens, du musst unserem Volk helfen, denn eine Bedrohung macht sich breit. Der Lord des Todes selbst, der Lord von Dunkelheit und Hass, ja er macht sich auf den Weg jedes unserer Königreiche weit und breit zu zerstören. Ohne deine Hilfe, ja das kannst du mir glauben, ohne deine Hilfe werden wir sterben. Du musst uns helfen. Was sagst du?“", "Sehr wohl mein Herr, ich der Krieger, werde verteidigen was zu verteidigen ist. Auch wenn ich mit meinem Tod bezahlen muss, ich werde unser Volk beschützen.", en1);


        capter1_2 = createNode("capter1_1 = createNode(\"Kapitel I – Eine schwere Entscheidung\\n\" +\n" +
                "                \"Es ist ein lauwarmer Herbsttag, Kinder spielen draußen, Frauen backen Brote, der Duft fliegt herrlich schmeckend durch die Luft. Wasser läuft dir im Mund zusammen, während du durch die unebenen Straßen gehst. Die Blätter der Bäume verfärben sich in die schönsten Farben um das Schloss von Raavensteen, deine Schritte gehen zielgerichtet auf das Tor zu. Der König lud dich ein mit ihm zu Essen,  allerdings vermutest du, dass das wohl nicht der einzige Grund sein mag. Die Wachen winken freundlich und bitten dich einzutreten. Das Haupttor des Saals öffnet sich und der König läuft dir entgegen, er nimmt dich in den Arm, seine Freude ist riesig. \\n\" +\n" +
                "                \"König: „Mein Freund, der Krieger, ich freue mich sehr. Komm mit, meine Diener bereiteten bereits das Essen vor, nun lass uns miteinander setzten. “\\n\", \"Weiter\", capter1_2);\n", "Weiter", capter1_3);


        capter1_1 = createNode("Kapitel I – Eine schwere Entscheidung\n" +
                "Es ist ein lauwarmer Herbsttag, Kinder spielen draußen, Frauen backen Brote, der Duft fliegt herrlich schmeckend durch die Luft. Wasser läuft dir im Mund zusammen, während du durch die unebenen Straßen gehst. Die Blätter der Bäume verfärben sich in die schönsten Farben um das Schloss von Raavensteen, deine Schritte gehen zielgerichtet auf das Tor zu. Der König lud dich ein mit ihm zu Essen,  allerdings vermutest du, dass das wohl nicht der einzige Grund sein mag. Die Wachen winken freundlich und bitten dich einzutreten. Das Haupttor des Saals öffnet sich und der König läuft dir entgegen, er nimmt dich in den Arm, seine Freude ist riesig. \n" +
                "König: „Mein Freund, der Krieger, ich freue mich sehr. Komm mit, meine Diener bereiteten bereits das Essen vor, nun lass uns miteinander setzten. “\n", "Weiter", capter1_2);


        information = createNode("Herzlich Willkommen Krieger!\n" +
                "Du begibst dich auf eine weite Reise in die unbekanntesten, dunkelsten und gefährlichsten Orte dieser Welt. Einfach, dieses Wort solltest du nicht kennen, denn das wird deine Reise nicht sein. Nicht nur deine Muskeln werden eine Verwendung finden, auch Rätsel, welche dein logisches Denkvermögen benötigt, wirst du nutzen müssen. \n" +
                "Nun begib dich auf die Reise und komme lebendig zurück, denn der Tod lauert hinter jeder Ecke.\n", "Weiter", capter1_1);






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
