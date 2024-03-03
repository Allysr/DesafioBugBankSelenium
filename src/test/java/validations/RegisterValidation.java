package validations;

import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.RegisterPage;

public class RegisterValidation {

    private WebDriver driver;

    private RegisterPage registerPage;


    public RegisterValidation(WebDriver driver) {
        this.driver = driver;
        this.registerPage = new RegisterPage(this.driver);
    }

    public void registerSuccessValidation(UserFactory user) {
        String account = "A conta " + user.getAccountNumber() + "-" + user.getId() + " foi criada com sucesso";
        String registerText = registerPage.getModalAccountText().getText();
        Assertions.assertEquals(account, registerText);
    }

}
