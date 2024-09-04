package lldInterview.preplaced.session3.splitwise;

import java.util.Map;
import java.util.UUID;

public class Expense {

    UUID expenseId;
    Integer groupId;
    String name;
    Map<Integer, Double> splits;
    Map<Integer, Double> payers;
    double totExpense;

    Integer expenseCreatorId;

    public Expense(Integer groupId, String name, Map<Integer, Double> splits, Map<Integer, Double> payers,
                   double totExpense, Integer userId) {
        this.expenseId = UUID.randomUUID();
        this.groupId = groupId;
        this.name = name;
        this.splits = splits;
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
                       ", splits=" + splits +
                       ", payers=" + payers +
                       ", totExpense=" + totExpense +
                       ", expenseCreatorId=" + expenseCreatorId +
                       '}';
    }

    public Map<Integer, Double> getPayers() {
        return payers;
    }

    public void setPayers(Map<Integer, Double> payers) {
        this.payers = payers;
    }

    public UUID getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(UUID expenseId) {
        this.expenseId = expenseId;
    }

    public Map<Integer, Double> getSplits() {
        return splits;
    }

    public void setSplits(Map<Integer, Double> splits) {
        this.splits = splits;
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
