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
            captureScreenshot(driver, "debitoRealizado-Sucesso");
        } catch(AssertionError e){
            captureScreenshot(driver, "debitoRealizado-Falha");
            throw e;
        }

    }

    public void addedBalanceValidation() {
        try{
            String value = "R$ 200,00";
            String extractBalance = extractPage.getExtractBalance().getText();
            captureScreenshot(driver, "creditoRecebido-Sucesso");
            Assertions.assertEquals(extractBalance, value);
            testPass("Credito recebido com sucesso.",
                    "Houve sucesso no recimento dos créditos.",
                    captureScreenshot(driver, "creditoRecebido-Sucesso")
            );
        } catch(AssertionError e){
            testFail("Credito recebido com falha.",
                    "Houve uma falha no recebimento do crédito.",
                    captureScreenshot(driver, "creditoRecebido-Falha")
            );
            throw e;
        }

    }
}
