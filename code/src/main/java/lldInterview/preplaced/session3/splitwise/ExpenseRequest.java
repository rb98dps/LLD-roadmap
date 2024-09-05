package lldInterview.preplaced.session3.splitwise;

import java.util.List;

public class ExpenseRequest {
    Expense expense;
    private ExpenseStage stage;
    private List<Balance> balance;
    public Expense getExpense() {
        return expense;
    }
    public void setExpense(Expense expense) {
        this.expense = expense;
    }
    public ExpenseStage getStage() {
        return stage;
    }
    public void setStage(ExpenseStage stage) {
        this.stage = stage;
    }
    public List<Balance> getBalance() {
        return balance;
    }
    public void setBalance(List<Balance> balance) {
        this.balance = balance;
    }

}
