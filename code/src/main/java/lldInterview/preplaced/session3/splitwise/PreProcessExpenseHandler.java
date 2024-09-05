package lldInterview.preplaced.session3.splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PreProcessExpenseHandler extends Handler{


    public PreProcessExpenseHandler(Handler handler) {
        super(handler);
    }

    @Override
    void handle(ExpenseRequest request) {

        if(request.getStage() == ExpenseStage.PRE){

            Expense expense = request.getExpense();
            Group group;
            if (expense.getGroupId() != null) {
                group = groupManager.getGroup(expense.getGroupId());
            } else {
                group =
                        groupManager.createGroup(expense.getExpenseCreatorId(),
                                new ArrayList<>(expense.getPayers().stream().map(Balance::getId).collect(Collectors.toList())),
                                "random");
                expense.setGroupId(group.getGroupId());
            }

            final List<Balance> balances = new ArrayList<>();
            for (int i = 0; i < expense.getPayers().size(); i++) {
                double value = expense.getPayers().get(i).getSplit() - expense.getPayers().get(i).getBal();
                balances.add(new Balance(group.getGroupId(expense.getPayers().get(i).getId()), value));
            }
            request.setBalance(balances);
            request.setStage(ExpenseStage.POST);
            super.handle(request);
        }
    }
}
