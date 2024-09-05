package lldInterview.preplaced.session3.splitwise;

import java.util.List;

public class PostProcessExpenseHandler extends Handler{
    public PostProcessExpenseHandler(Handler handler) {
        super(handler);
    }

    @Override
    void handle(ExpenseRequest request) {
        if(request.getStage() == ExpenseStage.POST){
            Expense expense = request.getExpense();
            List<List<Double>> newBalances = SplitWiseUtil.createEdgeList(request.getBalance());
            groupManager.updateGroupExpense(newBalances, expense.getTotExpense(), expense.getGroupId());
            request.setStage(ExpenseStage.COMPLETE);
        }
        super.handle(request);
    }
}
