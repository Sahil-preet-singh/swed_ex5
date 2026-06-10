package exercisde_5;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userID;
    private String name;
    private String email;
    private List<Subscription> subscriptions = new ArrayList<>();

    public User(int userID, String name, String email) {
        this.userID = userID;
        this.name = name;
        this.email = email;
    }

    public int getUserID()                     { return userID; }
    public String getName()                    { return name; }
    public List<Subscription> getSubscriptions() { return subscriptions; }
    public void addSubscription(Subscription s)    { subscriptions.add(s); }
    public void removeSubscription(Subscription s) { subscriptions.remove(s); }
}
