package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    public LoginPage (WebDriver driver){
        this.driver = driver;
    }
    public WebElement getEmail (){
        return driver.findElement(By.name("email"));
    }
    public WebElement getPassword (){
        return driver.findElement(By.name("password"));
    }
    public WebElement getAccessButton(){
        return driver.findElement(By.xpath("//button[text()='Acessar']"));
    }
    public WebElement getRegisterButton() {
        return driver.findElement(By.xpath("//button[text()='Registrar']"));
    }
}
