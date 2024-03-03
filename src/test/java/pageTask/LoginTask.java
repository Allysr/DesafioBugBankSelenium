package pageTask;

import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import pageElements.AccountPage;
import pageElements.LoginPage;
import validations.LoginValidation;

public class LoginTask {

    WebDriver driver;
    LoginPage loginPage;
    LoginValidation loginValidation;


    public LoginTask(WebDriver driver){
        this.driver = driver;
        this.loginPage = new LoginPage(this.driver);
        this.loginValidation = new LoginValidation(this.driver);
    }

    public void login(UserFactory user){
        loginPage.getEmail().sendKeys(user.getEmail());
        loginPage.getPassword().sendKeys(user.getPassword());
        loginPage.getAccessButton().click();
    }

    public void clickButtonRegister(){
        loginPage.getRegisterButton().click();
    }





}
