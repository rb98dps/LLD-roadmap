package behaviour.chainOfResponsibilty.simpleChain;

public class ConcreteHandler extends Handler{
    @Override
    void execute() {
        System.out.println("Executing service 0");
        if(this.getNextHandler() != null){
            getNextHandler().execute();
        }
    }
}

class ConcreteHandler1 extends Handler{
    @Override
    void execute() {
        System.out.println("Executing service 1");
        if(this.getNextHandler() != null){
            getNextHandler().execute();
        }
    }
}

class ConcreteHandler2 extends Handler{
    @Override
    void execute() {
        System.out.println("Executing service 2");
        if(this.getNextHandler() != null){
            getNextHandler().execute();
        }
    }
}
