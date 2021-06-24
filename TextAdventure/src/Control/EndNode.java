package Control;

public class EndNode extends Node{

    public EndNode(String text, Control control) {
        super(null, text, control);
    }

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
