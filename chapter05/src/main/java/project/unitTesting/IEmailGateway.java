package project.unitTesting;

public interface IEmailGateway {

    void sendGreetingsEmail(String userEmail);

    void sendRecipt(String email, String productName, int quantity);
}
