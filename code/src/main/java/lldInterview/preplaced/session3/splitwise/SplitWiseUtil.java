package lldInterview.preplaced.session3.splitwise;

import java.util.ArrayList;
import java.util.List;

public class SplitWiseUtil {


    private SplitWiseUtil() {

    }


    public static List<List<Double>> createEdgeList(List<Balance> balances) {


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

    private static void addEdge(List<Balance> balances, int start, int end, List<List<Double>> edges, Balance balanceS, double x, double y) {
        edges.get(balances.get(end).getId()).set(balances.get(start).getId(), y);
        edges.get(balances.get(start).getId()).set(balances.get(end).getId(), -y);
        balanceS.setBal(x);
    }


}
