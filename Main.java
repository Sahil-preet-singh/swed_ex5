package exercise_5;

public class Main {
    public static void main(String[] args) {

        UserController controller = new UserController();

        controller.registerUser("Alice", "alice@example.com");

        controller.manageSubscription("subscribe", 1, null,
            "https://example.com", Commchannel.EMAIL, 5);

        System.out.println("\n--- Check cycle ---");
        controller.runChecks();

        controller.manageSubscription("cancel", 1, "REG-1", null, null, 0);
    }
}
