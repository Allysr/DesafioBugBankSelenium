package validations;

import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;

import pageTask.RegisterTask;

public class RegisterValidation {

    private WebDriver driver;

    private RegisterTask registerTask;


    public RegisterValidation(WebDriver driver){
        this.driver = driver;
        this.registerTask = new RegisterTask(this.driver);
    }

    public void register(UserFactory user, Boolean balance) throws InterruptedException {
        registerTask.clickRegisterButton();
        registerTask.fillRegisterForm(user, balance);
        registerTask.clickCreateAccountButton();
        String account = registerTask.extractAccountNumber(user);
        Assertions.assertEquals("A conta " + account + " foi criada com sucesso", registerTask.getRegisterText());
        registerTask.clickCloseButton();
    }

}
