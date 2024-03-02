package suiteTest;

import browser.TestBase;
import validations.LoginValidation;
import validations.RegisterValidation;
import dataFactory.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TransferBetweenTwoAccounts extends TestBase {

    WebDriver driver = getDriver();
    RegisterValidation register = new RegisterValidation(driver);
    LoginValidation login = new LoginValidation(driver);

    UserFactory user01 = new UserFactory("Anna@teste.com", "anna", "senha", "senha");
    UserFactory user02 = new UserFactory("rico@teste.com", "Rico", "senha", "senha");

    @DisplayName("Deve realizar a transferencia entre contas com sucesso")
    @Test
    public void transferBetweenTwoAccounts() throws InterruptedException {
       register.register(user01, false);
       login.loginAndGetBalance(user01);
//       login.login(user01);

    }
}
