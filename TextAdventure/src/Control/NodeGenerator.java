package Control;

import GUI.GameWindow;
import Games.Pong;
import Games.Snake;
import Games.TicTacToe;

import java.sql.Time;
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

        Node en1, en2, en3, sn1, sn2, sn3, en4, information, capter1_1, capter1_2, en, capter2_1, capter3_1;

        en1 = createNode("Ihr Verliebt euch und werdet Glücklich.");
        en2 = createNode("Du hast dich verlaufen und findest den weg zurück nicht.");
        en3 = createNode("Du bist an Überforderung gestorben.");
        en4 = createNode("Du bist verhungert.");
        capter3_1 = createNode("SHit");
        capter2_1 = createNode("KAKA");
        en = createNode("Du bist leider Gesorben.");


        sn2 = createNode("Tic Tac Toe", "Ende 3", "Ende 3", "Ende 1", "Ende 2", en3, en3, en1, en2, new Runnable() {
            @Override
            public void run()
            {
                Snake snake = new Snake(control);
            }
        });

        capter3_1 = createNode("Gewinne Tic Tac Toe um den Fluss über die Steine zu überqueren.", "Betrete das Maisfeld vor dir.", "Laufe Nach Westen zur Sonne", "Laufe nach Süden.", "Ende 2", en3, en3, en1, en2, new Runnable() {
            @Override
            public void run()
            {
                TicTacToe ticTacToe = new TicTacToe(control);
            }
        });
        capter2_1 = createNode("Du bist auserathem. Du machst eine Pause und siehst in der Ferne eine Fremde Person.", "Hinlaufen", "Weg rennen", "Bleiben", "Verstecken", en1, en3, en4, en2);
        capter1_2 = createNode("Es sind nur noch wenige Meter bis zum Ort, aus dem Nichts vibriert der Boden.", "Zurücklaufen", "Schneller Laufen", "Westlich Über den Flüss Hüpfen.", "Erstaunt stehen beleiben", en1, capter2_1, capter3_1, en);
        capter1_1 = createNode("Du schlägst den Weg ein zum Königreich der Senses. Es ist ein Urvolk, welches seit langer Zeit gegen die dunklen Mächte dieser Welt kämpft. Das Urvolk besitzt unerklärliche Sinnesfähigkeiten, sie verspüren Gefühle. Die Schutzmauern allerdings, sehe nicht mehr so stabil wie damals aus.", "Weiter",  capter1_2);
        information = createNode("Herzlich Willkommen Krieger!\n" +
                "Du begibst dich auf eine weite Reise in die unbekanntesten, dunkelsten und \ngefährlichsten Orte dieser Welt. Einfach, dieses Wort solltest du nicht kennen,\ndenn das wird deine Reise nicht sein. Nicht nur deine Muskeln werden eine \nVerwendung finden, auch Aufgaben, welche dein logisches Denkvermögen sowie auch deine geschicklichkeit benötigt, wirst du nutzen müssen. \n" +
                "Nun begib dich auf die Reise und komme lebendig zurück, denn der Tod \nlauert hinter jeder Ecke.\n", "Weiter", capter1_1);

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
