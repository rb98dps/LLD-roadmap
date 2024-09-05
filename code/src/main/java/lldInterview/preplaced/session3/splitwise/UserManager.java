package lldInterview.preplaced.session3.splitwise;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static final UserManager userManager = new UserManager();
    private final Map<Integer, User> users = new HashMap<>();

    private UserManager() {

    }
    public static UserManager getInstance() {
        return userManager;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public User getUser(int userId) {
        return users.get(userId);
    }
}
