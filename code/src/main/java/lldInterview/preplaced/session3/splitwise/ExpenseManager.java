package lldInterview.preplaced.session3.splitwise;

import java.util.HashMap;
import java.util.Map;

public class ExpenseManager {
    private static final ExpenseManager expenseManager = new ExpenseManager();
    private final Map<Integer, Expense> users = new HashMap<>();

    private ExpenseManager() {

    }

    public static ExpenseManager getInstance() {
        return expenseManager;
    }

    public void addUser(Expense expense) {
        users.put(expense.getGroupId(), expense);
    }

    public Expense getUser(int userId) {
        return users.get(userId);
    }
}
