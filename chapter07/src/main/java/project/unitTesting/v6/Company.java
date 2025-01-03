package project.unitTesting.v6;

import lombok.Getter;

@Getter
public class Company {

    private String domainName;
    private int numberOfEmployees;

    public Company(String domainName, int numberOfEmplyees) {
        this.domainName = domainName;
        this.numberOfEmployees = numberOfEmplyees;
    }

    public void changeNumberOfEmployees(int delta) throws Exception {
        Precondition.requires(numberOfEmployees + delta >= 0);
        numberOfEmployees += delta;
    }

    public boolean isEmailCorporate(String email) {
        String emailDomain = email.split("@")[1];
        return emailDomain.equals(domainName);
    }
}
