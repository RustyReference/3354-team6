import java.util.*;

public class User {
    private String name;
    private final ArrayList<String> notificationList;

    public User(String name) {
        this.name = name;
        notificationList = new ArrayList<>();
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void addNotification(String notification) {
        notificationList.add(notification);
    }

    public int getNumNotif() {
        return notificationList.size();
    }
}
