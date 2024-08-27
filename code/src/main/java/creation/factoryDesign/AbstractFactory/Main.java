package creation.factoryDesign.AbstractFactory;


public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new IosFactory();
        AbstractFactory factory1 = new WindowsFactory();

        System.out.println(factory1.createButton());
        System.out.println(factory1.createDialog());

        System.out.println(factory.createButton());
        System.out.println(factory.createDialog());
    }
}
