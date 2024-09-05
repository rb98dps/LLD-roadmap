package lldInterview.preplaced.session3.splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static Splitwise splitwise = new Splitwise();

    public static void main(String[] args) {

        User user1 = splitwise.createUser("Rahul", "fasfdfdf", "3423525242");
        User user2 = splitwise.createUser("Rahul1", "fafsfdf", "3423525242");
        User user3 = splitwise.createUser("Rahul2", "sf", "3423525242");
        User user4 = splitwise.createUser("Rahul3", "fadfdf", "3423525242");

        Group g1 = splitwise.createGroup(user1.getUserId(), "Flat 1003", List.of(user2.getUserId(), user3.getUserId()));

        Group g2 = splitwise.createGroup(user2.getUserId(), "Flat 1003", List.of(user1.getUserId(), user2.getUserId()));


        System.out.println(splitwise.addUserToGroup(g1.getGroupId(), user2.getUserId(), user1.getUserId()));
        System.out.println(splitwise.addUserToGroup(g1.getGroupId(), user3.getUserId(), user2.getUserId()));

        System.out.println(splitwise.addUserToGroup(g1.getGroupId(), user4.getUserId(), user1.getUserId()));
        System.out.println(g1);

        Map<Integer, Pair> payers = Map.of(0, new Pair(100d, 300d), 1, new Pair(500d, 100d), 2, new Pair(200d, 160d), 3,
                new Pair(60d, 300d));

        double total = 860;
        Expense expense = new Expense(g1.getGroupId(), "expense 1 ", helper(payers), total, user1.getUserId());

        splitwise.addExpense(expense);

        printTransaction(splitwise.getTransactions(user1.getUserId(), g1.getGroupId()),user1.getUserId());

        printTransaction(splitwise.getTransactions(user3.getUserId(), g1.getGroupId()),user3.getUserId());


        payers = Map.of(0, new Pair(500d, 300d), 1, new Pair(100d, 100d), 2, new Pair(200d, 160d), 3,
                new Pair(60d, 300d));

        Expense expense1 = new Expense(g1.getGroupId(), "expense 2 ", helper(payers), total, user1.getUserId());

        g1.setRebalanceStrategy(new StraightUpRebalanceStrategy());
        splitwise.addExpense(expense1);

        printTransaction(splitwise.getTransactions(user1.getUserId(), g1.getGroupId()),user1.getUserId());

        printTransaction(splitwise.getTransactions(user2.getUserId(), g1.getGroupId()),user2.getUserId());

        splitwise.settle(new Transaction(1,400,3),g1.getGroupId());

        printTransaction(splitwise.getTransactions(user2.getUserId(), g1.getGroupId()),user2.getUserId());

    }

    private static void printTransaction(List<Transaction> transactions, Integer userId) {
        System.out.println("Transactions for " + userId);
        transactions.forEach(System.out::println);
    }

    public static List<Balance> helper(Map<Integer, Pair> payers) {
        List<Balance> list = new ArrayList<>();
        payers.forEach((k, v) -> list.add(new Balance(k, v.anInt, v.bnInt)));
        return list;
    }

    static class Pair {

        double anInt;
        double bnInt;

        public Pair(double anInt, double bnInt) {
            this.anInt = anInt;
            this.bnInt = bnInt;
        }
    }
}
