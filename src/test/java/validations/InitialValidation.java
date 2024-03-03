package validations;

import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.InitialPage;

public class InitialValidation {
    WebDriver driver;

    InitialPage initialPage;

    public InitialValidation(WebDriver driver){
        this.driver = driver;
        this.initialPage = new InitialPage(this.driver);

    }

    public void loginSuccessValidation(UserFactory user){
        String userLoginText = initialPage.getInicialText().getText();
        Assertions.assertEquals("Olá " + user.getName()+ ",", userLoginText );
    }
}
