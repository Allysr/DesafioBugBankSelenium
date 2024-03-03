package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.AccountPage;

public class AccountValidation {
    WebDriver driver;
    AccountPage accountPage;

    public AccountValidation (WebDriver driver){
        this.driver = driver;
        this.accountPage = new AccountPage(this.driver);
    }

    public void accountBalanceValidation(){
        String value = "Saldo em conta R$ 200,00";
        String textBalance = accountPage.getBalance().getText();
        Assertions.assertEquals(value, textBalance);
    }
}
