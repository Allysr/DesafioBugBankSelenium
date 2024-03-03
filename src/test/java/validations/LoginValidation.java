package validations;

import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.AccountPage;

public class LoginValidation {

    WebDriver driver;

    AccountPage accountPage;

    public LoginValidation(WebDriver driver){
        this.driver = driver;
        this.accountPage = new AccountPage(this.driver);

    }
    public void loginSuccessValidation(UserFactory user){
        String userLoginText = accountPage.getInicialText().getText();
        Assertions.assertEquals("Olá " + user.getName()+ ",", userLoginText );
    }

}
