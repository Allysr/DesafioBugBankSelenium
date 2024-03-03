package validations;

import org.openqa.selenium.WebDriver;
import pageElements.InitialPage;

public class LoginValidation {

    WebDriver driver;

    InitialPage initialPage;

    public LoginValidation(WebDriver driver){
        this.driver = driver;
        this.initialPage = new InitialPage(this.driver);

    }

//    public void loginAndGetBalance(UserFactory user){
//        login(user);
//        initialTask.extractUserBalance(user);
//        Assertions.assertEquals("Saldo em conta R$ 0,00", initialTask.getBalanceText());
//    }
}
