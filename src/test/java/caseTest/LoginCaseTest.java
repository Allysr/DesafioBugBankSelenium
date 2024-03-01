package caseTest;

import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import pageTask.LoginTask;

public class LoginCaseTest {


    WebDriver driver;
    LoginTask loginTask;
    public LoginCaseTest(WebDriver driver){
        this.driver = driver;
        this.loginTask = new LoginTask(this.driver);
    }

    @DisplayName("Deve realizar login com sucesso")
    public void login(UserFactory user){
        loginTask.fillLoginForm(user);
        loginTask.clickAccessButton();
        Assertions.assertEquals("Olá " + user.getName()+ ",", loginTask.getInitialText() );
    }
}
