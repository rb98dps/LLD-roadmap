package creation.prototype.someRealLifeExample;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Button button = new Button("Ok",2,"red");
        Button button1 = new Button("Close",2,"blue");
        Button button2 = new Button("Ok",2,"red");

        Dialog dialog = new Dialog("Well Done","message",new ArrayList<>(List.of(button,button2)));

        Dialog dialog1 = new Dialog("Garbage","message",new ArrayList<>(List.of(button1)));

        PrototypeRegistry<String,Dialog> prototypeRegistry = new DialogPrototypeRegistry<>();

        prototypeRegistry.add("red",dialog);
        prototypeRegistry.add("blue",dialog1);

        Dialog dialog11 = prototypeRegistry.get("red").get(0);
        System.out.println(dialog11 == dialog1);

    }
}
