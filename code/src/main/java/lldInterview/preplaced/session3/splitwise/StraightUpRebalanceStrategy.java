package lldInterview.preplaced.session3.splitwise;

import java.util.ArrayList;
import java.util.List;

public class StraightUpRebalanceStrategy implements RebalanceStrategy {

    @Override
    public List<List<Double>> balance(List<List<Double>> balances) {

        List<Balance> prunedBalances = new ArrayList<>();
        for (int i = 0; i < balances.size(); i++) {
            prunedBalances.add(new Balance(i, balances.get(i).stream().reduce(0d, Double::sum)));
        }

        return SplitWiseUtil.createEdgeList(prunedBalances);
    }
}
