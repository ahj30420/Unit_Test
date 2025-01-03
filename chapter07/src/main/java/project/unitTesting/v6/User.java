package project.unitTesting.v6;

import lombok.Getter;
import project.unitTesting.UserType;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {

    private int userId;
    private String email;
    private UserType type;
    private boolean isEmailConfirmed;
    private List<EmailChangedEvent> emailChangedEvents;

    public User(int userId, String email, UserType type, boolean isEmailConfirmed) {
        this.userId = userId;
        this.email = email;
        this.type = type;
        this.isEmailConfirmed = isEmailConfirmed;
        emailChangedEvents = new ArrayList<>();
    }

    public String canChangeEmail(){
        if(isEmailConfirmed){
            return "Can't change email after it's confirmed";
        }
        return null;
    }

    public void changeEmail(String newEmail, Company company) throws Exception {
        Precondition.requires(canChangeEmail() == null);

        if(email.equals(newEmail)) {
            return;
        }

        final UserType newType = company.isEmailCorporate(newEmail)
                ? UserType.EMPLOYEE
                : UserType.CUSTOMER;

        if(this.type != newType) {
            int delta = newType == UserType.EMPLOYEE ? 1 : -1;
            company.changeNumberOfEmployees(delta);
        }

        this.email = newEmail;
        this.type = newType;
        emailChangedEvents.add(new EmailChangedEvent(userId, newEmail));
    }
}
