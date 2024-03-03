package pageTask;

import browser.Waits;
import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageElements.InitialPage;
import pageElements.LoginPage;
import pageElements.RegisterPage;
import validations.RegisterValidation;

import static browser.Waits.fixedWaits;

public class RegisterTask {

    private WebDriver driver;
    private RegisterPage registerPage;

    private RegisterValidation registerValidation;
    private LoginTask loginTask;
    private LoginPage loginPage;

    private InitialPage initialPage;


    public RegisterTask(WebDriver driver){
        this.driver = driver;
        this.registerPage = new RegisterPage(this.driver);
        this.registerValidation = new RegisterValidation(this.driver);
        this.initialPage = new InitialPage(this.driver);
        this.loginPage = new LoginPage(this.driver);
    }

    public void register(UserFactory user, Boolean balance){
        loginPage.getRegisterButton().click();
        registerPage.getEmail().sendKeys(user.getEmail());
        registerPage.getName().sendKeys(user.getName());
        registerPage.getPassword().sendKeys(user.getPassword());
        registerPage.getPasswordConfirmation().sendKeys(user.getConfirmPassword());
        setBalance(balance);
        registerPage.getRegisterButton().click();
        extractAccountNumber(user);
        registerValidation.registerSuccessValidation(user);
        registerPage.getCloseButton().click();
    }

    public void extractAccountNumber(UserFactory user){
        String registerText = registerPage.getModalAccountText().getText();
        String[] removeSpaces = registerText.split(" ");
        String[] removeHyphen = removeSpaces[2].split("-");

        String number = removeHyphen[0];
        String id = removeHyphen[1];

        user.setAccountNumber(number);
        user.setId(id);
    }

    public void setBalance(boolean hasBalance) {
        Actions actions = new Actions(driver);
        if(hasBalance){
            actions.moveByOffset(0, 100).perform();
            registerPage.getToggle().click();
            fixedWaits(3000);
        }
    }


}
