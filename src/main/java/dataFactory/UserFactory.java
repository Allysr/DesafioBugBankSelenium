package dataFactory;

import java.math.BigDecimal;

public class UserFactory {
    private String email;
    private String name;
    private String password;
    private String confirmPassword;
    private BigDecimal balance;

    private String accountNumber;
    private String id;

    public UserFactory(String email, String name, String password, String confirmPassword) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }
}
