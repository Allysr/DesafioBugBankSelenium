package pageTask;

import browser.Waits;
import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageElements.RegisterPage;
import validations.RegisterValidation;

public class RegisterTask {

    private WebDriver driver;
    private Waits waits;
    private RegisterPage registerPage;
    private RegisterValidation registerValidation;
    private LoginTask loginTask;



    public RegisterTask(WebDriver driver){
        this.driver = driver;
        this.waits = new Waits(this.driver);
        this.registerPage = new RegisterPage(this.driver);
        this.registerValidation = new RegisterValidation(this.driver);
        this.loginTask = new LoginTask(this.driver);
    }

    public void register(UserFactory user, Boolean balance){
        loginTask.clickButtonRegister();
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
            waits.fixedWaits(2000);
        }
    }


}
