package creation.prototype.someRealLifeExample;

import creation.prototype.someRealLifeExample.ProtoType;

import java.util.ArrayList;
import java.util.List;

public class Dialog implements ProtoType {

    private String text;
    private String heading;

    public Dialog(String text, String heading, List<Button> buttons) {
        this.text = text;
        this.heading = heading;
        this.buttons = buttons;
    }

    private List<Button> buttons;

    @Override
    public ProtoType clone() {
        return new Dialog(text,heading,new ArrayList<>(buttons));
    }
}
