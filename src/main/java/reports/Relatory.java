package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Relatory {

    public static ExtentSparkReporter spark;
    public static ExtentReports extent;

    public static void relatoryConfiguration() {
        spark = new ExtentSparkReporter("src/Spark/RelatorioBugBank.html");

        extent = new ExtentReports();
        extent.attachReporter(spark);


    }
    public void blabla (){
        extent.createTest("ScreenCapture")
                .addScreenCaptureFromPath("src/Spark/pie.png")
                .pass(MediaEntityBuilder.createScreenCaptureFromPath("src/Spark/pie.png").build());
        extent.flush();
    }

    public void finishRelatory(){
        extent.flush();
    }


}
