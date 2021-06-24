package Control;

/**
 * @author Jonas Braus, Noah Kessinger
 */
public class InformationNode extends Node {

    public InformationNode(Edge[] edges, String text, Control control) {

        super(edges, text, control);
    }

    @Override
    public void onEnter()
    {
        control.initInfo();
        control.setOutputText(text);
        edges[0].onEnable();

    }
}