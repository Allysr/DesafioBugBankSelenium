package validations;

import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageTask.InitialTask;
import pageTask.LoginTask;

public class LoginValidation {

    WebDriver driver;
    LoginTask loginTask;
    InitialTask initialTask;
    public LoginValidation(WebDriver driver){
        this.driver = driver;
        this.loginTask = new LoginTask(this.driver);
        this.initialTask = new InitialTask(this.driver);
    }

    public void login(UserFactory user){
        loginTask.fillLoginForm(user);
        loginTask.clickAccessButton();
        Assertions.assertEquals("Olá " + user.getName()+ ",", initialTask.getInitialText() );
    }

    public void loginAndGetBalance(UserFactory user){
        login(user);
        initialTask.extractUserBalance(user);
        Assertions.assertEquals("Saldo em conta R$ 0,00", initialTask.getBalanceText());
    }
}
