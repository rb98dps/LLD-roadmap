package lldInterview.preplaced.session3.splitwise;

import java.util.List;

public interface RebalanceStrategy {
    List<List<Double>> balance(List<List<Double>> balances);
}
