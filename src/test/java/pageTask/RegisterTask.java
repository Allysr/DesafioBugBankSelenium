package pageTask;

import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import pageElements.LoginPage;
import pageElements.RegisterPage;
import validations.RegisterValidation;

import static browser.Waits.fixedWaits;

public class RegisterTask {

    private WebDriver driver;
    private RegisterPage registerPage;

    private RegisterValidation registerValidation;
    private LoginTask loginTask;


    public RegisterTask(WebDriver driver){
        this.driver = driver;
        this.registerPage = new RegisterPage(this.driver);
        this.loginTask = new LoginTask(this.driver);
        this.registerValidation = new RegisterValidation(this.driver);
    }

    public void registerUser (UserFactory user, Boolean balance){
        loginTask.clickRegisterButton();
        fillRegisterForm(user, balance);
        clickCreateAccountButton();
        extractAccountNumber(user);
        registerValidation.registerSuccessValidation(user);
        clickCloseButton();
    }

    public void fillRegisterForm (UserFactory user, Boolean balance) {
        registerPage.getEmail().sendKeys(user.getEmail());
        registerPage.getName().sendKeys(user.getName());
        registerPage.getPassword().sendKeys(user.getPassword());
        registerPage.getPasswordConfirmation().sendKeys(user.getConfirmPassword());
        if(balance){
            registerPage.getToggle().click();
            fixedWaits(3000);
        }
    }

    public String extractAccountNumber(UserFactory user){
        String registerText = registerPage.getModalAccountText().getText();
        String[] removeSpaces = registerText.split(" ");
        String[] removeHyphen = removeSpaces[2].split("-");

        String account = removeSpaces[2];
        String number = removeHyphen[0];
        String id = removeHyphen[1];

        user.setAccountNumber(number);
        user.setId(id);

        return account;
    }

    public void clickCloseButton(){
        registerPage.getCloseButton().click();
    }

    public void clickCreateAccountButton () {
        registerPage.getRegisterButton().click();
    }

    public String getRegisterText(){
        return registerPage.getModalAccountText().getText();
    }
}
