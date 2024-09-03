package behaviour.chainOfResponsibilty.simpleChain;

public class Main {
    public static void main(String[] args) {
        Handler concreteHandler1 = new ConcreteHandler1();
        Handler concreteHandler = new ConcreteHandler();
        Handler concreteHandler2 = new ConcreteHandler2();
        concreteHandler.setNextHandler(concreteHandler1);
        concreteHandler1.setNextHandler(concreteHandler2);
        concreteHandler.execute();
    }
}
