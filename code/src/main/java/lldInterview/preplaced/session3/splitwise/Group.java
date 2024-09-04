package lldInterview.preplaced.session3.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Group {

    private static final AtomicInteger atomicInteger = new AtomicInteger(0);
    public Map<Integer, Integer> userMaps = new HashMap<>();
    public Map<Integer, Integer> userReverseMaps = new HashMap<>();
    String name;
    int groupId;
    List<List<Double>> balances = new ArrayList<>();
    int leaderId;
    List<User> users = new ArrayList<>();
    double totExpense;
    RebalanceStrategy rebalanceStrategy;

    public Group(String name, User user, RebalanceStrategy rebalanceStrategy) {
        this.name = name;
        this.leaderId = user.getUserId();
        this.groupId = atomicInteger.getAndIncrement();
        this.rebalanceStrategy = rebalanceStrategy;
        addUser(user);

    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<List<Double>> getBalances() {
        return balances;
    }

    public void setBalances(List<List<Double>> balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "Group{" + "name='" + name + '\'' + ", groupId=" + groupId + ", balances=" + balances + ", leaderId=" + leaderId + ", userMaps=" + userMaps + ", users=" + users + ", totExpense=" + totExpense + '}';
    }

    private void incrementBalanceArray() {

        List<Double> list = new ArrayList<>();
        for (int i = 0; i < balances.size(); i++) {
            list.add(0d);
        }
        balances.add(list);

        for (List<Double> balance : balances) {
            balance.add(0d);
        }
    }

    public void addUser(User user) {

        users.add(user);
        userMaps.put(user.getUserId(),users.size() - 1);
        userReverseMaps.put(users.size() - 1,user.getUserId());
        incrementBalanceArray();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public RebalanceStrategy getRebalanceStrategy() {
        return rebalanceStrategy;
    }

    public void setRebalanceStrategy(RebalanceStrategy rebalanceStrategy) {
        this.rebalanceStrategy = rebalanceStrategy;
    }

    public Map<Integer, Integer> getUserMaps() {
        return userMaps;
    }

    public void setUserMaps(Map<Integer, Integer> userMaps) {
        this.userMaps = userMaps;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public double getTotExpense() {
        return totExpense;
    }

    public void setTotExpense(double totExpense) {
        this.totExpense = totExpense;
    }

    public HashMap<Integer, List<Transaction>> getFinalBalances() {
        List<List<Double>> finalBalances = rebalanceStrategy.balance(balances);
        HashMap<Integer, List<Transaction>> map = new HashMap<>();

        userMaps.forEach((k, v) -> {
            List<Transaction> list = new ArrayList<>();
            for (int i = 0; i < finalBalances.get(v).size(); i++) {
                Transaction transaction = new Transaction(k, finalBalances.get(v).get(i), userReverseMaps.get(i));
                list.add(transaction);
            }
            map.put(k, list);
        });

        return map;

    }

    public List<Transaction> getFinalBalancesForUser(int userId) {
        return getFinalBalances().get(userId);
    }

    public void addBalances(List<List<Double>> newBalances, double tot) {
        int n = userMaps.size();
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                double balance = balances.get(i).get(i1) + newBalances.get(i).get(i1);
                balances.get(i).set(i1, balance);
            }
        }
        totExpense += tot;
    }
}
