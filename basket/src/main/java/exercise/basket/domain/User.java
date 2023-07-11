package exercise.basket.domain;

public class User {

    private String email;
    private String accountType;

    public User() {
    }

    public User(String email, String accountType) {
        this.email = email;
        this.accountType = accountType;
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public String getAccountType() {
        return accountType;
    }
}
