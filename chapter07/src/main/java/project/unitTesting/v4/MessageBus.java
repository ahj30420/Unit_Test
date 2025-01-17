package project.unitTesting.v4;

import project.unitTesting.IBus;

public class MessageBus {

    private IBus bus;

    public void sendEmailChangeMessage(int userId, String newEmail) {
        bus.send(String.format("Subject: USER; Type: EMAIL CHANGED; Id: %d; NewEmail: %s", userId, newEmail));
    }
}