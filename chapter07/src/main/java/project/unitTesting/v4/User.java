package project.unitTesting.v4;

import lombok.Getter;
import project.unitTesting.UserType;

@Getter
public class User {

    private int userId;
    private String email;
    private UserType type;

    public User(int userId, String email, UserType type) {
        this.userId = userId;
        this.email = email;
        this.type = type;
    }

    public void changeEmail(String newEmail, Company company) throws Exception {
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
    }
}
