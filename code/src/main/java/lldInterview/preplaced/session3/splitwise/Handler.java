package lldInterview.preplaced.session3.splitwise;

public abstract class Handler {

    public GroupManager groupManager = GroupManager.getInstance();
    Handler nextHandler;

    void handle(ExpenseRequest request){
        if(nextHandler!= null){
            nextHandler.handle(request);
        }
    }

    public Handler(Handler handler){
        nextHandler = handler;
    }
}
