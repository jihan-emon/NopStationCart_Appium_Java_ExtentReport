import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtentReport {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    @BeforeSuite
    public void reportSetup(){

        // start reporters
        htmlReporter = new ExtentHtmlReporter("extent.html");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


    }

    @AfterSuite
    public void reportTeardown() {

        extent.flush();


    }
}
