package pageTask;

import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import pageElements.LoginPage;
import pageElements.RegisterPage;

public class RegisterTask {

    private WebDriver driver;
    private RegisterPage registerPage;
    private LoginPage loginPage;


    public RegisterTask(WebDriver driver){
        this.driver = driver;
        this.registerPage = new RegisterPage(this.driver);
        this.loginPage = new LoginPage(this.driver);
    }

    public void clickRegisterButton () {
        loginPage.getRegisterButton().click();
    }

    public void fillRegisterForm (UserFactory user, Boolean balance) throws InterruptedException {
        registerPage.getEmail().sendKeys(user.getEmail());
        registerPage.getName().sendKeys(user.getName());
        registerPage.getPassword().sendKeys(user.getPassword());
        registerPage.getPasswordConfirmation().sendKeys(user.getConfirmPassword());
        if(balance){
            registerPage.getToggle().click();
            Thread.sleep(3000);
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
