package pageTask;

import browser.Waits;
import org.openqa.selenium.WebDriver;
import pageElements.AccountPage;

public class AccountTask {
    WebDriver driver;

    AccountPage accountPage;

    public AccountTask(WebDriver driver){
        this.driver = driver;
        this.accountPage = new AccountPage(this.driver);
    }

    public void clickExitButton(){
        accountPage.getExitButton().click();
    }

    public void clickTransferButton(){
        accountPage.getTransferButton().click();
    }

    public void clickExtractButton(){
        accountPage.getExtractButton().click();
    }

}
