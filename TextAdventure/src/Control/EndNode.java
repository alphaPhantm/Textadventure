package Control;

/**
 * @author Jonas Braus, Noah Kessinger
 * A Node that represents the end of the game.
 */
public class EndNode extends Node{
    /**
     * Constructor for the EndNode
     * @param text
     * @param control
     */
    public EndNode(String text, Control control) {
        super(null, text, control);
    }

    /**
     * Function that declares the entrance behaviour of the EndNode
     */
    @Override
    public void onEnter()
    {


        control.setOutputText(text);
        for(int i = 0; i < 4; i++)
        {
            control.setButtonText(i, "");
        }

        control.gameEnd();
    }
}
