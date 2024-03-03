package pageTask;

import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import pageElements.InitialPage;
import pageElements.LoginPage;
import validations.InitialValidation;

public class LoginTask {

    WebDriver driver;
    LoginPage loginPage;

    InitialPage initialPage;

    InitialValidation initialValidation;

    public LoginTask(WebDriver driver){
        this.driver = driver;
        this.loginPage = new LoginPage(this.driver);
        this.initialValidation = new InitialValidation(this.driver);
        this.initialPage = new InitialPage(this.driver);
    }

    public void login(UserFactory user){
        loginPage.getEmail().sendKeys(user.getEmail());
        loginPage.getPassword().sendKeys(user.getPassword());
        loginPage.getAccessButton().click();
        initialValidation.loginSuccessValidation(user);
    }

    public void clickExitButton(){
        initialPage.getExitButton().click();
    }



}
