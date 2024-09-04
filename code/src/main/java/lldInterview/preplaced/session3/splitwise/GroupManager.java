package lldInterview.preplaced.session3.splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupManager {

    private static final GroupManager groupManager = new GroupManager();
    Map<Integer, Group> groups;
    private final UserManager userManager = UserManager.getInstance();

    private GroupManager() {

    }

    public static GroupManager getInstance() {
        return groupManager;
    }

    public boolean addGroupUser(Integer groupId, Integer id, User user) {
        Group group = groups.get(groupId);
        if (id != group.getLeaderId()) {
            return false;
        }
        group.addUser(user);
        return true;
    }

    public void addGroup(Group group) {
        if (groups == null)
            groups = new HashMap<>();

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
        return group;
    }

    public Group getGroup(int id) {
        return groups.get(id);
    }

}
