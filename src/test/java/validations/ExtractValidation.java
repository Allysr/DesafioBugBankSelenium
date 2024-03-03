package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.ExtractPage;

public class ExtractValidation {

    WebDriver driver;

    ExtractPage extractPage;

    public  ExtractValidation (WebDriver driver) {
        this.driver = driver;
        this.extractPage = new ExtractPage(this.driver);
    }

    public void deductedBalanceValidation() {
        String value = "R$ 800,00";
        String extractBalance = extractPage.getExtractBalance().getText();
        Assertions.assertEquals(extractBalance, value);
    }

    public void addedBalanceValidation() {
        String value = "R$ 200,00";
        String extractBalance = extractPage.getExtractBalance().getText();
        Assertions.assertEquals(extractBalance, value);
    }
}
