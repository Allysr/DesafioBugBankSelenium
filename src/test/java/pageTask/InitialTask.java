package pageTask;

import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import pageElements.InitialPage;

import java.math.BigDecimal;

public class InitialTask {

    WebDriver driver;
    InitialPage initialPage;

    public InitialTask(WebDriver driver){
        this.driver = driver;
        this.initialPage = new InitialPage(this.driver);
    }
    public String getInitialText(){
        return initialPage.getInicialText().getText();
    }

    public void extractUserBalance(UserFactory user){
        String balanceText = initialPage.getBalance().getText();
        String replaceText = balanceText.replaceAll("[^0-9,]", "");
        replaceText = replaceText.replace(",", ".");
        BigDecimal balance = new BigDecimal(replaceText);
        user.setBalance(balance);

    }

    public String getBalanceText(){
        return initialPage.getBalance().getText();
    }


}
