package pageTask;

import browser.Waits;
import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import pageElements.TransferPage;
import validations.ExtractValidation;
import validations.TransferValidation;

public class TransferTask {

    private WebDriver driver;
    private Waits waits;

    private TransferPage transferPage;
    private AccountTask accountTask;
    private TransferValidation transferValidation;
    private ExtractValidation extractValidation;

    public TransferTask(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        transferPage = new TransferPage(this.driver);
        accountTask = new AccountTask(this.driver);
        transferValidation = new TransferValidation(this.driver);
        extractValidation = new ExtractValidation(this.driver);
    }

    public void transfer(UserFactory user, int value, String description) {
        accountTask.clickTransferButton();
        transferPage.getAccountNumber().sendKeys(user.getAccountNumber());
        transferPage.getDigit().sendKeys(user.getId());
        transferPage.getTransferValue().sendKeys(String.valueOf(value));
        transferPage.getDescription().sendKeys(description);
        transferPage.getButtonTransferNow().click();
        transferValidation.transferSuccessValidation();
        waits.loadElement(transferPage.getButtonClose());
        transferPage.getButtonClose().click();
        waits.loadElement(transferPage.getButtonBack());
        transferPage.getButtonBack().click();
        accountTask.clickExtractButton();
        extractValidation.deductedBalanceValidation();
        accountTask.clickExitButton();
    }


}
