package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.AccountPage;
import pageElements.TransferPage;

import static reports.Relatory.testFail;
import static reports.Relatory.testPass;
import static reports.Screenshot.captureScreenshot;

public class TransferValidation {
    WebDriver driver;

    AccountPage accountPage;
    TransferPage transferPage;

    public TransferValidation (WebDriver driver) {
        this.driver = driver;
        this.accountPage = new AccountPage(this.driver);
        this.transferPage = new TransferPage(this.driver);
    }

    public void transferSuccessValidation () {
        try{
            String successText = "Transferencia realizada com sucesso";
            String transferText = transferPage.getTextTransferPage().getText();
            Assertions.assertEquals(successText, transferText);
            testPass("Houve sucesso na realização da transferencia.",
                    captureScreenshot(driver, "transferenciaRealizada-Sucesso")
            );
        } catch(AssertionError e){
            testFail("Houve uma falha na realização da transferência.",
                    captureScreenshot(driver, "transferenciaRealizada-Falha")
            );
            throw e;
        }

    }
}
