import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
@Listeners(ITestListener.class)

public class nopstationCart extends ExtentReport {

    //Global
    static AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void Navigate_to_the_EMI_Calculator_screen() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "Redmi Note_7");
        dc.setCapability("udid", "b8cf3b7");
        dc.setCapability("platformVersion", "10");
        dc.setCapability("appPackage", "com.continuum.emi.calculator");
        dc.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");
        dc.setCapability("autoGrantPermissions", "true");
        URL url = new URL ("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Application started......");
        ExtentTest test = extent.createTest("App launched", "Will complete three(03) different test scenarios");
        test.log(Status.INFO, "Successfully Navigated to the EMI Calculator Screen");
    }

    @Test(priority = 0)
    public void EMI_Package_01() throws Exception {
        MyScreenRecorder.startRecording("");
        ExtentTest test = extent.createTest("EMI_Package_01", "Will also Verify the EMI Plan");
        test.log(Status.INFO, "EMI_Package_01 is Started....");
        driver.findElement(By.id("com.continuum.emi.calculator:id/btnStart")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.continuum.emi.calculator:id/etLoanAmount")).click();
        driver.hideKeyboard();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etLoanAmount")).sendKeys("100000");
        driver.findElement(By.id("com.continuum.emi.calculator:id/etInterest")).click();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etInterest")).sendKeys("9.0");
        driver.findElement(By.id("com.continuum.emi.calculator:id/etYears")).click();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etYears")).sendKeys("2");
        driver.findElement(By.id("com.continuum.emi.calculator:id/etFee")).click();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etFee")).sendKeys("2.0");
        driver.findElement(By.id("com.continuum.emi.calculator:id/btnCalculate")).click();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        test.log(Status.INFO, "Calculation done");
        //Monthly EMI
        String Expected_Monthly_EMI = "4,568.47";
        String Actual_Monthly_EMI = driver.findElementById("com.continuum.emi.calculator:id/monthly_emi_result").getText();
        Assert.assertTrue(Expected_Monthly_EMI.equalsIgnoreCase(Actual_Monthly_EMI), "Monthly EMI Amount Mismatch");
        //Total Interest
        String Expected_Total_Interest = "9,643.38";
        String Actual_Total_Interest = driver.findElementById("com.continuum.emi.calculator:id/total_interest_result").getText();
        Assert.assertTrue(Expected_Total_Interest.equalsIgnoreCase(Actual_Total_Interest), "Total Interest Amount Mismatch");
        //Processing Fee
        String Expected_Processing_Fee = "2,000";
        String Actual_Processing_Fee = driver.findElementById("com.continuum.emi.calculator:id/processing_fee_result").getText();
        Assert.assertTrue(Expected_Processing_Fee.equalsIgnoreCase(Actual_Processing_Fee), "Processing_Fees Amount Mismatch");
        //Total Payment
        String Expected_Total_Payment = "109,643.38";
        String Actual_Total_Payment = driver.findElementById("com.continuum.emi.calculator:id/total_payment_result").getText();
        Assert.assertTrue(Expected_Total_Payment.equalsIgnoreCase(Actual_Total_Payment), "Total_Payable_Amount Mismatch");
        test.log(Status.INFO, "Verification done");
        test.log(Status.INFO, "EMI_Package_01 is passed");
        MyScreenRecorder.stopRecording();


    }

    @Test(priority = 1)
    public void EMI_Package_02() throws Exception {

        MyScreenRecorder.startRecording("");
        ExtentTest test = extent.createTest("EMI_Package_02", "Will also Verify the EMI Plan");
        test.log(Status.INFO, "EMI_Package_02 is Started....");
        //Click on Reset
        driver.findElement(By.id("com.continuum.emi.calculator:id/btnReset")).click();
        test.log(Status.INFO, "Button Reset done");
        Thread.sleep(1000);
        driver.findElement(By.id("com.continuum.emi.calculator:id/etLoanAmount")).click();
        driver.hideKeyboard();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etLoanAmount")).sendKeys("325000");
        driver.findElement(By.id("com.continuum.emi.calculator:id/etInterest")).click();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etInterest")).sendKeys("9.5");
        driver.findElement(By.id("com.continuum.emi.calculator:id/etYears")).click();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etYears")).sendKeys("5");
        driver.findElement(By.id("com.continuum.emi.calculator:id/etFee")).click();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etFee")).sendKeys("1.5");
        driver.findElement(By.id("com.continuum.emi.calculator:id/btnCalculate")).click();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        test.log(Status.INFO, "Calculation done");
        //Monthly EMI
        String Expected_Monthly_EMI = "6,825.6";
        String Actual_Monthly_EMI = driver.findElementById("com.continuum.emi.calculator:id/monthly_emi_result").getText();
        Assert.assertTrue(Expected_Monthly_EMI.equalsIgnoreCase(Actual_Monthly_EMI), "Monthly EMI Amount Mismatch");
        //Total Interest
        String Expected_Total_Interest = "84,536.3";
        String Actual_Total_Interest = driver.findElementById("com.continuum.emi.calculator:id/total_interest_result").getText();
        Assert.assertTrue(Expected_Total_Interest.equalsIgnoreCase(Actual_Total_Interest), "Total Interest Amount Mismatch");
        //Processing Fee
        String Expected_Processing_Fee = "4,875";
        String Actual_Processing_Fee = driver.findElementById("com.continuum.emi.calculator:id/processing_fee_result").getText();
        Assert.assertTrue(Expected_Processing_Fee.equalsIgnoreCase(Actual_Processing_Fee), "Processing_Fees Amount Mismatch");
        //Total Payment
        String Expected_Total_Payment = "409,536.3";
        String Actual_Total_Payment = driver.findElementById("com.continuum.emi.calculator:id/total_payment_result").getText();
        Assert.assertTrue(Expected_Total_Payment.equalsIgnoreCase(Actual_Total_Payment), "Total_Payable_Amount Mismatch");
        test.log(Status.INFO, "Verification done");
        test.log(Status.INFO, "EMI_Package_02 is passed");
        MyScreenRecorder.stopRecording();


    }

    @Test(priority = 2)
    public void EMI_Package_03() throws Exception {
        MyScreenRecorder.startRecording("");
        ExtentTest test = extent.createTest("EMI_Package_03", "Will also Verify the EMI Plan");
        test.log(Status.INFO, "EMI_Package_03 is Started....");
        //Click on Reset
        driver.findElement(By.id("com.continuum.emi.calculator:id/btnReset")).click();
        Thread.sleep(1000);
        test.log(Status.INFO, "EButton Reset Done");
        driver.findElement(By.id("com.continuum.emi.calculator:id/etLoanAmount")).click();
        driver.hideKeyboard();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etLoanAmount")).sendKeys("450000");
        driver.findElement(By.id("com.continuum.emi.calculator:id/etInterest")).click();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etInterest")).sendKeys("11.0");
        driver.findElement(By.id("com.continuum.emi.calculator:id/etYears")).click();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etYears")).sendKeys("7");
        driver.findElement(By.id("com.continuum.emi.calculator:id/etFee")).click();
        driver.findElement(By.id("com.continuum.emi.calculator:id/etFee")).sendKeys("1.8");
        driver.findElement(By.id("com.continuum.emi.calculator:id/btnCalculate")).click();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        test.log(Status.INFO, "Calculation Done");
        //Monthly EMI
        String Expected_Monthly_EMI = "7,705.1";
        String Actual_Monthly_EMI = driver.findElementById("com.continuum.emi.calculator:id/monthly_emi_result").getText();
        Assert.assertTrue(Expected_Monthly_EMI.equalsIgnoreCase(Actual_Monthly_EMI), "Monthly EMI Amount Mismatch");
        //Total Interest
        String Expected_Total_Interest = "197,228.1";
        String Actual_Total_Interest = driver.findElementById("com.continuum.emi.calculator:id/total_interest_result").getText();
        Assert.assertTrue(Expected_Total_Interest.equalsIgnoreCase(Actual_Total_Interest), "Total Interest Amount Mismatch");
        //Processing Fee
        String Expected_Processing_Fee = "8,100";
        String Actual_Processing_Fee = driver.findElementById("com.continuum.emi.calculator:id/processing_fee_result").getText();
        Assert.assertTrue(Expected_Processing_Fee.equalsIgnoreCase(Actual_Processing_Fee), "Processing_Fees Amount Mismatch");
        //Total Payment Failed (Added an extra 0)
        String Expected_Total_Payment = "647,228.10";
        String Actual_Total_Payment = driver.findElementById("com.continuum.emi.calculator:id/total_payment_result").getText();
        Assert.assertTrue(Expected_Total_Payment.equalsIgnoreCase(Actual_Total_Payment), "Total_Payable_Amount is Mismatched");
        test.log(Status.INFO, "EMI_Package_03 is passed");
        MyScreenRecorder.stopRecording();




    }

    @AfterTest
    public void close() {

        driver.quit();


    }






}
