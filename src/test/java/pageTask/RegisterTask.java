package pageTask;

import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class RegisterTask {

    private WebDriver driver;
    private RegisterPage registerPage;
    private LoginPage loginPage;


    public RegisterTask(WebDriver driver){
        this.driver = driver;
        this.registerPage = new RegisterPage(this.driver);
        this.loginPage = new LoginPage(this.driver);
    }

//    public void register(UserFactory user) throws InterruptedException {
////        loginPage.getRegisterButton().click();
//        registerPage.getEmail().sendKeys(user.getEmail());
//        registerPage.getName().sendKeys(user.getName());
//        registerPage.getPassword().sendKeys(user.getPassword());
//        registerPage.getPasswordConfirmation().sendKeys(user.getConfirmPassword());
//        registerPage.getToggle().click();
//        Thread.sleep(3000);
//        registerPage.getRegisterButton().click();
//        String registerText = registerPage.getModalAccountText();
//        String[] removeSpaces = registerText.split(" ");
//        String[] removeHyphen = removeSpaces[2].split("-");
//
//        String number = removeHyphen[0];
//        String id = removeHyphen[1];
//
//        user.setAccountNumber(number);
//        user.setId(id);
//
//        Assertions.assertEquals("A conta " + removeSpaces[2] + " foi criada com sucesso", registerText);
//
//        registerPage.getCloseButton().click();
//
//    }

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
