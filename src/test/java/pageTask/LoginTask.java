package pageTask;

import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageObjects.InitialPage;
import pageObjects.LoginPage;

public class LoginTask {

    WebDriver driver;
    LoginPage loginPage;

    InitialPage initialPage;


    public LoginTask(WebDriver driver){
        this.driver = driver;
        this.loginPage = new LoginPage(this.driver);
        this.initialPage = new InitialPage(this.driver);
    }

    public void fillLoginForm (UserFactory user)  {
        loginPage.getEmail().sendKeys(user.getEmail());
        loginPage.getPassword().sendKeys(user.getPassword());
    }

    public void clickAccessButton(){
        loginPage.getAccessButton().click();
    }

    public String getInitialText(){
        return initialPage.getInicialText().getText();
    }

}
