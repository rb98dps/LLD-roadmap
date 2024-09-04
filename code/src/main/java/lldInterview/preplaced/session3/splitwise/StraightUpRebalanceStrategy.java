package lldInterview.preplaced.session3.splitwise;

import java.util.ArrayList;
import java.util.List;

public class StraightUpRebalanceStrategy implements RebalanceStrategy {


    ExpenseRebalancer expenseRebalancer = ExpenseRebalancer.getInstance();

    @Override
    public List<List<Double>> balance(List<List<Double>> balances) {

        List<Balance> prunedBalances = new ArrayList<>();

        for (int i = 0; i < balances.size(); i++) {
            prunedBalances.add(new Balance(i, balances.get(i).stream().reduce(0d, Double::sum)));
        }

        return expenseRebalancer.createEdgeList(prunedBalances);

    }
}
