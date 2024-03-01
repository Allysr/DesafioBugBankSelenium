package suiteTest;

import browser.TestBase;
import caseTest.LoginCaseTest;
import caseTest.RegisterCaseTest;
import dataFactory.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageTask.RegisterTask;

public class TransferBetweenTwoAccounts extends TestBase {

    WebDriver driver = getDriver();
    RegisterCaseTest registerCaseTest = new RegisterCaseTest(driver);
    LoginCaseTest loginCaseTest = new LoginCaseTest(driver);

    UserFactory user01 = new UserFactory("Anna@teste.com", "anna", "senha", "senha");
    UserFactory user02 = new UserFactory("rico@teste.com", "Rico", "senha", "senha");

    @DisplayName("Deve realizar a transferencia entre contas com sucesso")
    @Test
    public void transferBetweenTwoAccounts() throws InterruptedException {
       registerCaseTest.register(user01, true);
       loginCaseTest.login(user01);



    }
}
