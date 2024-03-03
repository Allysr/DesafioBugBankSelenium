package validations;

import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.RegisterPage;

import static reports.Relatory.testFail;
import static reports.Relatory.testPass;
import static reports.Screenshot.captureScreenshot;

public class RegisterValidation {

    private WebDriver driver;

    private RegisterPage registerPage;


    public RegisterValidation(WebDriver driver) {
        this.driver = driver;
        this.registerPage = new RegisterPage(this.driver);
    }

    public void registerSuccessValidation(UserFactory user) {
        try{
            String account = "A conta " + user.getAccountNumber() + "-" + user.getId() + " foi criada com sucesso";
            String registerText = registerPage.getModalAccountText().getText();
            Assertions.assertEquals(account, registerText);
            testPass("Cadastro realizado com sucesso.",
                    "Houve sucesso na realização do cadastro.",
                    captureScreenshot(driver, "cadastroRealizado-Sucesso")
            );
        } catch(AssertionError e){
            testFail("Cadastro com falha.",
                    "Houve uma falha na realização do cadastro.",
                    captureScreenshot(driver, "cadastroRealizado-Falha")
            );
            throw e;
        }

    }

}
