package behaviour.chainOfResponsibilty.simpleChain;

public abstract class Handler {
    private Handler nextHandler;
    abstract void execute();

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
