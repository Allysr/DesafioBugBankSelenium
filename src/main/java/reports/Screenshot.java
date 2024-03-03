package reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static utils.DateFormater.formattedDate;
import static utils.DateFormater.formattedDateAndHour;

public class Screenshot {

    public static void captureScreenshot(WebDriver driver, String name) {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            String dateAndHour = formattedDateAndHour();
            String date = formattedDate();

            String destinationFile = "reports/screenshots-" + date + "/" + name + "_" + dateAndHour + ".png";

            File targetFile = new File(destinationFile);

            FileUtils.copyFile(SrcFile, targetFile);

            System.out.println("Screenshot captured: " + destinationFile);
        } catch (Exception e) {
            System.out.println("Error while capturing screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
