package exercise_4;

import java.util.Date;

public class NotificationService implements Observer {
    private Commchannel channel;
    public Date timeStamp;

    public NotificationService(Commchannel channel) {
        this.channel = channel;
    }

    @Override
    public void update(String url) {
        sendNotification(url, channel);
    }

    public void sendNotification(String url, Commchannel channel) {
        this.timeStamp = new Date();
        String msg = "Update detected at: " + url;
        switch (channel) {
            case EMAIL -> System.out.println("[EMAIL] " + msg);
            case SMS   -> System.out.println("[SMS]   " + msg);
            case PUSH  -> System.out.println("[PUSH]  " + msg);
        }
    }
}
