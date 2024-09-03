package behaviour.chainOfResponsibilty.betterChain;

public class ConcreteHandler extends BaseHandler {
    @Override
    public void execute() {
        System.out.println("Executing service 0");
        super.execute();
    }

}

class ConcreteHandler1 extends BaseHandler {
    @Override
    public void execute() {
        System.out.println("Executing service 1");
        super.execute();
    }
}

class ConcreteHandler2 extends BaseHandler {
    @Override
    public void execute() {
        System.out.println("Executing service 2");
        super.execute();
    }
}
