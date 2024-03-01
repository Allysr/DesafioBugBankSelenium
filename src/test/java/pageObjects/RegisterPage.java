package pageObjects;

import browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;
    private Waits waits;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        this.waits = new Waits(this.driver);
    }
    public WebElement getEmail(){
        return driver.findElement(By.xpath("(//input[@name=\'email\'])[2]"));
    }
    public WebElement getName(){
        return driver.findElement(By.name("name"));
    }
    public WebElement getPassword(){
        return driver.findElement(By.xpath("(//input[@name=\'password\'])[2]"));
    }
    public WebElement getPasswordConfirmation(){
        return driver.findElement(By.name("passwordConfirmation"));
    }
    public WebElement getRegisterButton(){
        return  waits.visibilityOfElement(By.xpath("//button[text()='Cadastrar']"));
    }
    public WebElement getToggle() {
        return driver.findElement(By.id("toggleAddBalance"));
    }
    public WebElement getModalAccountText() {
        return waits.visibilityOfElement(By.id("modalText"));
    }

    public WebElement getCloseButton(){
        return driver.findElement(By.id("btnCloseModal"));
    }
}
