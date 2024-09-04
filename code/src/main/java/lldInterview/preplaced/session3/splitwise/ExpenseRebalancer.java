package lldInterview.preplaced.session3.splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpenseRebalancer {

    private static final ExpenseRebalancer expenseRebalancer = new ExpenseRebalancer();
    public static GroupManager groupManager = GroupManager.getInstance();

    private ExpenseRebalancer() {

    }

    public static ExpenseRebalancer getInstance() {
        return expenseRebalancer;
    }

    public List<List<Double>> rebalance(Expense expense) {

        Group group;

        if (expense.getGroupId() != null) {
            group = groupManager.getGroup(expense.getGroupId());
        } else {
            group =
                    groupManager.createGroup(expense.getExpenseCreatorId(),
                            new ArrayList<>(expense.getPayers().keySet()), "random");
        }

        final List<Balance> balances = new ArrayList<>();
        expense.getSplits().forEach((k, v) -> {
            double value = v - expense.getPayers().get(k);
            balances.add(new Balance(k, value));
        });

        return createEdgeList(balances, group.getUserMaps());

    }

    public List<List<Double>> createEdgeList(List<Balance> balances, Map<Integer, Integer> userMaps) {


        int start = 0;
        int end = balances.size() - 1;
        List<List<Double>> edges = new ArrayList<>();

        for (int i = 0; i <= end; i++) {
            edges.add(new ArrayList<>());
            for (int j = 0; j <= end; j++) {
                edges.get(i).add(0d);
            }
        }


        balances.sort((a, b) -> (int) (a.getBal() - b.getBal()));
        System.out.println(balances);
        while (start < end) {
            Balance balanceE = balances.get(end);
            Balance balanceS = balances.get(start);
            double x = balanceE.getBal() + balanceS.getBal();
            double y = Math.min(Math.abs(balanceE.getBal()), Math.abs(balanceS.getBal()));
            System.out.println("x = " + x + "y = " + y);
            if (x > 0) {
                addEdge(balances, userMaps, start, end, edges, balanceE, x, y);
                start++;
            } else if (x < 0) {
                addEdge(balances, userMaps, start, end, edges, balanceS, x, y);
                end--;
            } else {
                addEdge(balances, userMaps, start, end, edges, balanceS, x, y);
                start++;
                end--;
            }

        }
        return edges;
    }

    public List<List<Double>> createEdgeList(List<Balance> balances) {


        int start = 0;
        int end = balances.size() - 1;
        List<List<Double>> edges = new ArrayList<>();

        for (int i = 0; i <= end; i++) {
            edges.add(new ArrayList<>());
            for (int j = 0; j <= end; j++) {
                edges.get(i).add(0d);
            }
        }


        balances.sort((a, b) -> (int) (a.getBal() - b.getBal()));
        while (start < end) {
            Balance balanceE = balances.get(end);
            Balance balanceS = balances.get(start);
            double x = balanceE.getBal() + balanceS.getBal();
            double y = Math.min(Math.abs(balanceE.getBal()), Math.abs(balanceS.getBal()));
            if (x > 0) {
                addEdge(balances, start, end, edges, balanceE, x, y);
                start++;
            } else if (x < 0) {
                addEdge(balances, start, end, edges, balanceS, x, y);
                end--;
            } else {
                addEdge(balances, start, end, edges, balanceS, x, y);
                start++;
                end--;
            }

        }
        return edges;
    }

    private void addEdge(List<Balance> balances, Map<Integer, Integer> userMaps, int start, int end, List<List<Double>> edges, Balance balanceS, double x, double y) {
        edges.get(userMaps.get(balances.get(end).getId())).set(userMaps.get(balances.get(start).getId()), -y);
        edges.get(userMaps.get(balances.get(start).getId())).set(userMaps.get(balances.get(end).getId()), y);
        balanceS.setBal(x);
    }

    private void addEdge(List<Balance> balances, int start, int end, List<List<Double>> edges, Balance balanceS, double x, double y) {
        edges.get(balances.get(end).getId()).set(balances.get(start).getId(), -y);
        edges.get(balances.get(start).getId()).set(balances.get(end).getId(), y);
        balanceS.setBal(x);
    }


}
