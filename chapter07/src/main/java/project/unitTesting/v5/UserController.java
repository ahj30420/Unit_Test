package project.unitTesting.v5;

public class UserController {

    private final Database database = new Database();
    private final MessageBus messageBus = new MessageBus();

    public String changeEmail(int userId, String newEmail) throws Exception {
        final Object[] userData = database.getUserById(userId);
        final User user = UserFactory.create(userData);

        final Object[] companyData = database.getCompany();
        Company company = CompanyFactory.create(companyData);

        user.changeEmail(newEmail, company);

        database.saveCompany(company);
        database.saveUser(user);
        messageBus.sendEmailChangeMessage(userId, newEmail);

        return "OK";
    }
}
