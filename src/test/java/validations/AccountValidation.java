package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.AccountPage;

import static reports.Relatory.testFail;
import static reports.Relatory.testPass;
import static reports.Screenshot.captureScreenshot;

public class AccountValidation {
    WebDriver driver;

    AccountPage accountPage;

    public AccountValidation (WebDriver driver) {
        this.driver = driver;
        this.accountPage = new AccountPage(this.driver);
    }

    public void accountBalanceValidation() {
        try{
            String value = "Saldo em conta R$ 1.200,00";
            String textBalance = accountPage.getBalance().getText();
            Assertions.assertEquals(value, textBalance);
            testPass("Houve sucesso no recebimento do saldo.",
                    captureScreenshot(driver, "saldoNaConta-Sucesso")
            );
        } catch(AssertionError e){
            testFail("Houve uma falha no recebimento do saldo.",
                    captureScreenshot(driver, "saldoNaConta-Falha")
            );
            throw e;
        }

    }
}
