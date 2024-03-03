package suiteTest;

import browser.TestBase;
import dataFactory.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageTask.LoginTask;
import pageTask.RegisterTask;

import static data.Data.userAnna;

public class TransferBetweenTwoAccounts extends TestBase {

    WebDriver driver = getDriver();
    RegisterTask registerTask = new RegisterTask(this.driver);
    LoginTask loginTask = new LoginTask(this.driver);
    UserFactory user01 = userAnna();

    @DisplayName("Deve realizar a transferencia entre contas com sucesso")
    @Test
    public void transferBetweenTwoAccounts(){
        registerTask.registerUser(user01, false);
        loginTask.login(user01);
    }
}
