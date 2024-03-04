package pageTask;

import browser.Waits;
import org.openqa.selenium.WebDriver;
import pageElements.ExtractPage;
import validations.AccountValidation;
import validations.ExtractValidation;

import static reports.Relatory.createTest;

public class ExtractTask {
    WebDriver driver;
    Waits waits;

    AccountTask accountTask;
    AccountValidation accountValidation;
    ExtractValidation extractValidation;
    ExtractPage extractPage;

    public ExtractTask(WebDriver driver) {
        this.driver = driver;
        this.accountTask = new AccountTask(this.driver);
        this.waits = new Waits(this.driver);
        this.extractPage = new ExtractPage(this.driver);
        this.accountValidation = new AccountValidation(this.driver);
        this.extractValidation = new ExtractValidation(this.driver);
    }

    public void verifyExtract() {
        createTest("Validar saldo na conta", "Deve validar o saldo na conta");
        accountValidation.accountBalanceValidation();
        accountTask.clickExtractButton();
        extractValidation.addedBalanceValidation();
        accountTask.clickExitButton();
    }

}
