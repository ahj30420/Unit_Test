package project.unitTesting.v4;

import project.unitTesting.UserType;

public class UserFactory {

    public static User create(Object[] data) throws Exception {
        Precondition.requires(data.length >= 3);

        final int id = (int) data[0];
        final String email = (String) data[1];
        final UserType type = (UserType) data[2];

        return new User(id, email, type);
    }
}
