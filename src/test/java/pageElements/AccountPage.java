package pageElements;

import browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AccountPage {

    private WebDriver driver;
    private Waits waits;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        this.waits = new Waits(this.driver);
    }

    public WebElement getTransferButton(){
        return waits.visibilityOfElement(By.id("btn-TRANSFERÊNCIA"));
    }

    public WebElement getExtractButton(){
        return waits.visibilityOfElement(By.id("btn-EXTRATO"));
    }

    public WebElement getExitButton() {
        return waits.visibilityOfElement(By.id("btnExit"));
    }

    public WebElement getBalance() {
        return driver.findElement(By.id("textBalance"));
    }

    public WebElement getInicialText(){
        return  driver.findElement(By.id("textName"));
    }


}
