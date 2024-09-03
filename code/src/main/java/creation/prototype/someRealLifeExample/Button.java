package creation.prototype.someRealLifeExample;


public class Button implements ProtoType {
    private String text;

    public Button(String text, Integer borderSize, String backgroundColor) {
        this.text = text;
        this.borderSize = borderSize;
        this.backgroundColor = backgroundColor;
    }

    private Integer borderSize;
    private String backgroundColor;


    @Override
    public ProtoType clone() {
        return new Button(text,borderSize,backgroundColor);
    }
}
