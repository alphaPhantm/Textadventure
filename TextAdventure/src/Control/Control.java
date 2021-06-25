package Control;

import GUI.GUI;

/**
 * @author Jonas Braus, Noah Kessinger
 * the control class manages the game. It controls the sequence.
 */
public class Control {

    private GUI gui;
    private NodeGenerator nodeGenerator;
    private Node activeNode = null;

    /**
     * Constructor of Control with no parameters
     */
    public Control() {
        //create the new default JFrame and a node generator
        gui = new GUI(this);
        nodeGenerator = new NodeGenerator(this);
    }

    /**
     * function that calls activate function of an edge
     * @param index
     */
    public void activateEdge(int index) {
        activeNode.edges[index].activate();
    }

    /**
     * function that activates a new node
     * @param node
     */
    public void setActiveNode(Node node) {
        activeNode = node;
        activeNode.onEnter();
    }

    /**
     * function that sets text on a button
     * @param index
     * @param text
     */
    public void setButtonText(int index, String text) {
        gui.setButtonText(index, text);
    }

    /**
     * function that hides all buttons
     */
    public void gameEnd() {
        for (int i = 0; i < 4; i++) {
            gui.hideButtons(i);
        }

    }

    /**
     * function that hides the selection buttons and shows the info button
     */
    public void initInfo() {
        gui.initInfo();
    }

    /**
     * function that hides the info button and shows the selection buttons
     */
    public void exitInfo(){
        gui.exitInfo();
    }

    /**
     * function that sets text to the output field
     * @param text
     */
    public void setOutputText(String text) {
        gui.setOutputText(text);
    }

}
