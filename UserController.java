package exercise_5;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users = new ArrayList<>();
    private List<MonitorWebsite> monitors = new ArrayList<>();
    private int userCounter = 0;
    private int subCounter = 0;

    public void registerUser(String name, String email) {
        users.add(new User(++userCounter, name, email));
        System.out.println("User registered: " + name);
    }

    public void manageSubscription(String action, int userID, String regID,
                                   String url, Commchannel channel, int frequency) {
        User user = findUser(userID);
        if (user == null) return;

        switch (action) {
            case "subscribe" -> {
                String id = "REG-" + (++subCounter);
                Subscription sub = new Subscription(id, url, channel, frequency);
                user.addSubscription(sub);

                MonitorWebsite monitor = new MonitorWebsite(sub, frequency);
                NotificationService notifService = new NotificationService(channel);
                monitor.addObserver(notifService);
                monitors.add(monitor);
                System.out.println("Subscribed to: " + url);
            }
            case "update" -> {
                Subscription sub = findSubscription(user, regID);
                if (sub != null) sub.updateSubscription(channel, frequency);
            }
            case "cancel" -> {
                Subscription sub = findSubscription(user, regID);
                if (sub != null) { sub.cancelSubscription(); user.removeSubscription(sub); }
            }
        }
    }

    public void createNotification(int userID, String regID) {
        User user = findUser(userID);
        if (user == null) return;
        Subscription sub = findSubscription(user, regID);
        if (sub == null) return;
        new NotificationService(sub.getCommunication())
            .sendNotification(sub.getUrl(), sub.getCommunication());
    }

    public void runChecks() {
        for (MonitorWebsite m : monitors) m.checkForUpdate();
    }

    private User findUser(int userID) {
        return users.stream().filter(u -> u.getUserID() == userID).findFirst().orElse(null);
    }

    private Subscription findSubscription(User user, String regID) {
        return user.getSubscriptions().stream()
            .filter(s -> s.getRegistrationID().equals(regID)).findFirst().orElse(null);
    }
}
