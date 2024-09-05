package lldInterview.preplaced.session3.splitwise;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static final AtomicInteger atomicInteger = new AtomicInteger(0);
    private String name;
    private String password;

    private String phNo;
    private int userId;
    private List<Group> groups;
    public User(String name, String password, String phNo) {
        this.name = name;
        this.password = password;
        this.phNo = phNo;
        userId = atomicInteger.getAndIncrement();
    }

    @Override
    public String toString() {
        return "User{" +
                       "name='" + name + '\'' +
                       ", password='" + password + '\'' +
                       ", phNo='" + phNo + '\'' +
                       ", userId=" + userId +
                       ", groups=" + groups +
                       '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void add(Group group) {
        groups.add(group);
    }

}
