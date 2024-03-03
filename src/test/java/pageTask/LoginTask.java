package pageTask;

import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import pageElements.LoginPage;

public class LoginTask {

    WebDriver driver;
    LoginPage loginPage;

    public LoginTask(WebDriver driver){
        this.driver = driver;
        this.loginPage = new LoginPage(this.driver);
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
