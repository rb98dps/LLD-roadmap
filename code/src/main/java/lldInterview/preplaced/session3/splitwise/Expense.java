package lldInterview.preplaced.session3.splitwise;

import java.util.List;
import java.util.UUID;

public class Expense {

    private UUID expenseId;
    private Integer groupId;
    private String name;
    private List<Balance>  payers;
    private double totExpense;

    private Integer expenseCreatorId;

    public Expense(Integer groupId, String name,  List<Balance> payers,
                   double totExpense, Integer userId) {
        this.expenseId = UUID.randomUUID();
        this.groupId = groupId;
        this.name = name;
        this.payers = payers;
        this.totExpense = totExpense;
        this.expenseCreatorId = userId;
    }

    public Integer getExpenseCreatorId() {
        return expenseCreatorId;
    }

    public void setExpenseCreatorId(Integer expenseCreatorId) {
        this.expenseCreatorId = expenseCreatorId;
    }

    @Override
    public String toString() {
        return "Expense{" +
                       "expenseId=" + expenseId +
                       ", groupId=" + groupId +
                       ", name='" + name + '\'' +
                       ", payers=" + payers +
                       ", totExpense=" + totExpense +
                       ", expenseCreatorId=" + expenseCreatorId +
                       '}';
    }

    public  List<Balance> getPayers() {
        return payers;
    }

    public void setPayers( List<Balance> payers) {
        this.payers = payers;
    }

    public UUID getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(UUID expenseId) {
        this.expenseId = expenseId;
    }


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotExpense() {
        return totExpense;
    }

    public void setTotExpense(double totExpense) {
        this.totExpense = totExpense;
    }


}
