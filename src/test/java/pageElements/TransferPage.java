package pageElements;

import browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferPage {
    private WebDriver driver;
    private Waits waits;

    public TransferPage (WebDriver driver){
        this.driver = driver;
        this.waits =  new Waits(this.driver);
    }
    public WebElement getAccountNumber(){
        return waits.visibilityOfElement(By.name("accountNumber"));
    }
    public WebElement getDigit(){
        return  driver.findElement(By.name("digit"));
    }
    public WebElement getTransferValue(){
        return driver.findElement(By.name("transferValue"));
    }
    public WebElement getDescription(){
        return driver.findElement(By.name("description"));
    }
    public WebElement getButtonTransferNow(){
        return driver.findElement(By.xpath("//button[text()='Transferir agora']"));
    }
    public WebElement getModalText() {
        return waits.visibilityOfElement(By.id("modalText"));
    }
    public WebElement getButtonClose(){
        return waits.visibilityOfElement(By.id("btnCloseModal"));
    }
    public WebElement getTextTransferPage(){
        return waits.visibilityOfElement(By.id("modalText"));
    }
    public WebElement getButtonBack(){
        return waits.visibilityOfElement(By.id("btnBack"));
    }


}
