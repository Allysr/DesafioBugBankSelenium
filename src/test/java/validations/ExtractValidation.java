package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.ExtractPage;

import static reports.Relatory.testFail;
import static reports.Relatory.testPass;
import static reports.Screenshot.captureScreenshot;

public class ExtractValidation {

    WebDriver driver;

    ExtractPage extractPage;

    public  ExtractValidation (WebDriver driver) {
        this.driver = driver;
        this.extractPage = new ExtractPage(this.driver);
    }

    public void deductedBalanceValidation() {
        try{
            String value = "R$ 800,00";
            String extractBalance = extractPage.getExtractBalance().getText();
            Assertions.assertEquals(extractBalance, value);
            testPass("Houve sucesso na realização do débito.",
                    captureScreenshot(driver, "debitoRealizado-Sucesso")
            );
        } catch(AssertionError e){
            testFail("Houve uma falha na realização do débito.",
                    captureScreenshot(driver, "debitoRealizado-Falha")
            );
            throw e;
        }

    }

    public void addedBalanceValidation() {
        try{
            String value = "R$ 1.200,00";
            String extractBalance = extractPage.getExtractBalance().getText();
            Assertions.assertEquals(extractBalance, value);
            testPass("Houve sucesso no recebimento dos créditos.",
                    captureScreenshot(driver, "creditoRecebido-Sucesso")
            );
        } catch(AssertionError e){
            testFail(
                    "Houve uma falha no recebimento do crédito.",
                    captureScreenshot(driver, "creditoRecebido-Falha")
            );
            throw e;
        }

    }
}
