package suiteTest;

import browser.TestBase;
import dataFactory.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageTask.*;

import static data.Data.userAnna;
import static data.Data.userJoana;

public class TransferBetweenTwoAccounts extends TestBase {

    private WebDriver driver = getDriver();

    private RegisterTask registerTask = new RegisterTask(this.driver);
    private LoginTask loginTask = new LoginTask(this.driver);
    private AccountTask accountTask = new AccountTask(this.driver);
    private TransferTask transferTask = new TransferTask(this.driver);
    private ExtractTask  extractTask = new ExtractTask(this.driver);

    UserFactory anna = userAnna();
    UserFactory joana = userJoana();


    @DisplayName("Deve realizar a transferencia entre contas com sucesso")
    @Test
    public void transferBetweenTwoAccounts() {
        registerTask.register(anna,false);
        loginTask.login(anna);
        accountTask.clickExitButton();
        registerTask.register(joana,true);
        loginTask.login(joana);
        transferTask.transfer(anna, 200, "Parabéns!");
        loginTask.login(anna);
        extractTask.verifyExtract();

    }


}
