package exercise_5;

public class Subscription {
    private String registrationID;
    private String url;
    private Commchannel communication;
    public int frequency;
    private String lastKnownContent;
    private boolean active = true;

    public Subscription(String registrationID, String url, Commchannel communication, int frequency) {
        this.registrationID = registrationID;
        this.url = url;
        this.communication = communication;
        this.frequency = frequency;
    }

    public void updateSubscription(Commchannel communication, int frequency) {
        this.communication = communication;
        this.frequency = frequency;
    }

    public void cancelSubscription() { this.active = false; }

    public String getRegistrationID()         { return registrationID; }
    public String getUrl()                    { return url; }
    public Commchannel getCommunication()     { return communication; }
    public boolean isActive()                 { return active; }
    public String getLastKnownContent()       { return lastKnownContent; }
    public void setLastKnownContent(String c) { this.lastKnownContent = c; }
}
