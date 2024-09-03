package behaviour.chainOfResponsibilty.betterChain;

public class Main {
    public static void main(String[] args) {
        BaseHandler concreteHandler1 = new ConcreteHandler1();
        BaseHandler concreteHandler = new ConcreteHandler();
        BaseHandler concreteHandler2 = new ConcreteHandler2();
        concreteHandler.setNextHandler(concreteHandler1);
        concreteHandler1.setNextHandler(concreteHandler2);
        concreteHandler.execute();
    }
}
