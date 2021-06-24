package Control;

import GUI.GUI;

public class Control {

    private GUI gui;
    private NodeGenerator nodeGenerator;
    private Node activeNode = null;

    public Control() {
        gui = new GUI(this);
        nodeGenerator = new NodeGenerator(this);
    }

    public void activateEdge(int index) {
        activeNode.edges[index].activate();
    }

    public void setActiveNode(Node node) {
        activeNode = node;
        activeNode.onEnter();
    }

    public void setButtonText(int index, String text) {
        gui.setButtonText(index, text);
    }

    public void gameEnd() {
        for (int i = 0; i < 4; i++) {
            gui.hideButtons(i);
        }

    }

    public void initInfo() {
        gui.initInfo();
    }

    public void exitInfo(){
        gui.exitInfo();
    }

    public void setOutputText(String text) {
        gui.setOutputText(text);
    }
}
