package pageTask;

import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import pageElements.LoginPage;
import validations.InitialValidation;

public class LoginTask {

    WebDriver driver;
    LoginPage loginPage;

    InitialValidation initialValidation;

    public LoginTask(WebDriver driver){
        this.driver = driver;
        this.loginPage = new LoginPage(this.driver);
        this.initialValidation = new InitialValidation(this.driver);
    }

    public void login(UserFactory user){
        clickAccessButton();
        fillLoginForm(user);
        clickAccessButton();
        initialValidation.loginSuccessValidation(user);

    }

    public void fillLoginForm (UserFactory user)  {
        loginPage.getEmail().sendKeys(user.getEmail());
        loginPage.getPassword().sendKeys(user.getPassword());
    }

    public void clickAccessButton(){
        loginPage.getAccessButton().click();
    }

    public void clickRegisterButton() {
        loginPage.getRegisterButton().click();
    }


}
