package lldInterview.preplaced.session3.splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static GroupManager groupManager = GroupManager.getInstance();

    public static ExpenseRebalancer expenseRebalancer = ExpenseRebalancer.getInstance();

    public static void main(String[] args) {

        User user = new User("Rahul", "fadf", "3423525242");
        User user1 = new User("Rahul1", "fadf", "3423525242");
        User user2 = new User("Rahul2", "fadf", "3423525242");
        User user3 = new User("Rahul3", "fadf", "3423525242");
        Group group = new Group("first", user, new StraightUpRebalanceStrategy());
        groupManager.addGroup(group);
        groupManager.addGroupUser(group.getGroupId(), user.getUserId(), user1);
        groupManager.addGroupUser(group.getGroupId(), user.getUserId(), user2);
        groupManager.addGroupUser(group.getGroupId(), user.getUserId(), user3);
        System.out.println(groupManager.getGroup(group.getGroupId()));

        Map<Integer, Double> payers = Map.of(0, 100d, 1, 500d, 2, 200d, 3, 60d);
        Map<Integer, Double> splits = Map.of(0, 300d, 1, 100d, 2, 160d, 3, 300d);
        double total = 860;
        Expense expense = new Expense(group.getGroupId(), "expense 1 ", splits, payers, total, user.getUserId());

        System.out.println(expenseRebalancer.rebalance(expense));
        group.addBalances(expenseRebalancer.rebalance(expense), expense.getTotExpense());
        System.out.println(groupManager.getGroup(group.getGroupId()));
        HashMap<Integer, List<Transaction>> finalBalances = group.getFinalBalances();

        finalBalances.forEach((k,v) ->{
            System.out.println("Transactions for " + k);
            v.forEach(System.out::println);
            System.out.println();
        });

        Map<Integer, Double> payers1 = Map.of(1, 100d, 0, 500d, 2, 200d, 3, 60d);
        Map<Integer, Double> splits1 = Map.of(0, 300d, 1, 100d, 2, 160d, 3, 300d);
        double total1 = 860;
        Expense expense1 = new Expense(group.getGroupId(), "expense 2 ", splits1, payers1, total1, user.getUserId());


        System.out.println(expenseRebalancer.rebalance(expense1));
        group.addBalances(expenseRebalancer.rebalance(expense1), expense1.getTotExpense());
        System.out.println(groupManager.getGroup(group.getGroupId()));
        finalBalances = group.getFinalBalances();

        finalBalances.forEach((k,v) ->{
            System.out.println("Transactions for " + k);
            v.forEach(System.out::println);
            System.out.println();
        });

        function();

    }

    private static void function() {
        User user = new User("Rahul", "fadf", "3423525242");
        User user1 = new User("Rahul1", "fadf", "3423525242");
        User user2 = new User("Rahul2", "fadf", "3423525242");
        User user3 = new User("Rahul3", "fadf", "3423525242");
        Group group = new Group("first", user, new StraightUpRebalanceStrategy());
        groupManager.addGroup(group);
        groupManager.addGroupUser(group.getGroupId(), user.getUserId(), user1);
        groupManager.addGroupUser(group.getGroupId(), user.getUserId(), user2);
        groupManager.addGroupUser(group.getGroupId(), user.getUserId(), user3);
        System.out.println(groupManager.getGroup(group.getGroupId()));

        Map<Integer, Double> payers = Map.of(4, 100d, 5, 500d, 7, 200d, 6, 60d);
        Map<Integer, Double> splits = Map.of(4, 300d, 5, 100d, 7, 160d, 6, 300d);
        double total = 860;
        Expense expense = new Expense(group.getGroupId(), "expense 1 ", splits, payers, total, user.getUserId());

        System.out.println(expenseRebalancer.rebalance(expense));
        group.addBalances(expenseRebalancer.rebalance(expense), expense.getTotExpense());
        System.out.println(groupManager.getGroup(group.getGroupId()));
        HashMap<Integer, List<Transaction>> finalBalances = group.getFinalBalances();

        finalBalances.forEach((k,v) ->{
            System.out.println("Transactions for " + k);
            v.forEach(System.out::println);
            System.out.println();
        });

        Map<Integer, Double> payers1 = Map.of(4, 100d, 6, 500d, 7, 200d, 5, 60d);
        Map<Integer, Double> splits1 = Map.of(4, 300d, 7, 100d, 5, 160d, 6, 300d);
        double total1 = 860;
        Expense expense1 = new Expense(group.getGroupId(), "expense 2 ", splits1, payers1, total1, user.getUserId());


        System.out.println(expenseRebalancer.rebalance(expense1));
        group.addBalances(expenseRebalancer.rebalance(expense1), expense1.getTotExpense());
        System.out.println(groupManager.getGroup(group.getGroupId()));
        finalBalances = group.getFinalBalances();

        finalBalances.forEach((k,v) ->{
            System.out.println("Transactions for " + k);
            v.forEach(System.out::println);
            System.out.println();
        });
    }
}
