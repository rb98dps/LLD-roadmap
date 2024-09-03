package behaviour.chainOfResponsibilty.betterChain;

public  class BaseHandler implements Handler{
    private BaseHandler nextHandler;
    public void execute(){
        if(nextHandler!= null){
            nextHandler.execute();
        }
    }

    public BaseHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(BaseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
