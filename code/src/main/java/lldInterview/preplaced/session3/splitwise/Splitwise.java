package lldInterview.preplaced.session3.splitwise;

import java.util.List;

public class Splitwise {


    Handler posthandler = new PostProcessExpenseHandler(null);
    Handler handler = new PreProcessExpenseHandler(posthandler);

    GroupManager groupManager = GroupManager.getInstance();

    UserManager userManager = UserManager.getInstance();

    public boolean addExpense(Expense expense) {
        ExpenseRequest request = new ExpenseRequest();
        request.setExpense(expense);
        request.setStage(ExpenseStage.PRE);
        handler.handle(request);

        return request.getStage() == ExpenseStage.COMPLETE;
    }

    public void settle(Transaction transaction, Integer groupId) {
        groupManager.settle(transaction, groupId);
    }

    public List<Transaction> getTransactions(Integer userId, Integer groupId) {
        return groupManager.getGroup(groupId).getFinalBalancesForUser(userId);
    }

    public User createUser(String name, String password, String phNo) {
        User user = new User(name, password, phNo);
        userManager.addUser(user);
        return user;
    }

    public boolean addUserToGroup(Integer groupId, Integer userId, Integer leaderId) {
        return groupManager.addGroupUser(groupId, leaderId, userManager.getUser(userId));
    }

    public Group createGroup(Integer userId, String name, List<Integer> userIds) {
        return groupManager.createGroup(userId, userIds, name);
    }
}
