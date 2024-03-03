package suiteTest;

import browser.TestBase;
import dataFactory.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageTask.LoginTask;
import pageTask.RegisterTask;

import static data.Data.userAnna;
import static data.Data.userJoana;

public class TransferBetweenTwoAccounts extends TestBase {

    WebDriver driver = getDriver();
    RegisterTask registerTask = new RegisterTask(this.driver);
    LoginTask loginTask = new LoginTask(this.driver);
    InitialTask initialTask = new InitialTask(this.driver);
    UserFactory user01 = userAnna();
    UserFactory user02 = userJoana();


    @DisplayName("Deve realizar a transferencia entre contas com sucesso")
    @Test
    public void transferBetweenTwoAccounts(){
        registerTask.register(user01,  false);
        loginTask.login(user01);
        loginTask.clickExitButton();
        registerTask.register(user02, true);
        loginTask.login(user02);
























//        registerTask.registerUser(user01, false);
//        registerTask.clickCloseButton();
//        loginTask.login(user01);
//        initialTask.extractUserBalance(user01);
//        initialTask.clickCloseButton();
//        registerTask.registerUser(user02, true);
//        registerTask.clickCloseButton();


    }


}
