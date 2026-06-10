package exercise_5;

import java.util.ArrayList;
import java.util.List;

public class MonitorWebsite implements Observable {
    public int checkInterval;
    private Subscription subscription;
    private List<Observer> observers = new ArrayList<>();

    public MonitorWebsite(Subscription subscription, int checkInterval) {
        this.subscription = subscription;
        this.checkInterval = checkInterval;
    }

    public void addObserver(Observer o)    { observers.add(o); }
    public void removeObserver(Observer o) { observers.remove(o); }

    public void notifyObservers() {
        for (Observer o : observers) o.update(subscription.getUrl());
    }

    public void checkForUpdate() {
        if (!subscription.isActive()) return;
        String current = fetchContent();
        if (detectUpdate(current)) {
            System.out.println("Update found: " + subscription.getUrl());
            notifyObservers();
        }
        subscription.setLastKnownContent(current);
    }

    public boolean detectUpdate(String current) {
        if (subscription.getLastKnownContent() == null) return false;
        return !subscription.getLastKnownContent().equals(current);
    }

    private String fetchContent() {
        // Mockup
        return "content-of-" + subscription.getUrl();
    }

    public Subscription getSubscription() { return subscription; }
}
