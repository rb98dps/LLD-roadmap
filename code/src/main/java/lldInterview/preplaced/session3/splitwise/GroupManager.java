package lldInterview.preplaced.session3.splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupManager {

    private static final GroupManager groupManager = new GroupManager();
    private final Map<Integer, Group> groups = new HashMap<>();
    private final UserManager userManager = UserManager.getInstance();

    private GroupManager() {

    }

    public static GroupManager getInstance() {
        return groupManager;
    }

    public boolean addGroupUser(Integer groupId, Integer id, User user) {
        Group group = groups.get(groupId);
        if (id == group.getLeaderId() && !group.getUserMaps().containsKey(user.getUserId())) {
            group.addUser(user);
            return true;
        }
        return false;
    }

    public void addGroup(Group group) {
        groups.put(group.getGroupId(), group);
    }

    public Group createGroup(int leaderId, List<Integer> userIdList, String name) {
        Group group = new Group(name, userManager.getUser(leaderId), new SimpleRebalanceStrategy());
        for (Integer id : userIdList) {
            User user = userManager.getUser(id);
            if (user.getUserId() != group.getLeaderId()) {
                group.addUser(user);
            }
        }
        addGroup(group);
        return group;
    }

    public Group getGroup(int id) {
        return groups.get(id);
    }


    public void updateGroupExpense(List<List<Double>> newBalances,Double total, Integer groupId){
        getGroup(groupId).addBalances(newBalances,total);
    }

    public void settle(Transaction transaction, Integer groupId){
        getGroup(groupId).settle(transaction.getSenderId(), transaction.getReceiverId(), transaction.getBalance());
    }
}
