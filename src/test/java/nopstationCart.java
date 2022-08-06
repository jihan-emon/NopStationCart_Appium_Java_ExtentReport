import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
@Listeners(ITestListener.class)

public class nopstationCart extends ExtentReport {
    //Global
    static AppiumDriver<MobileElement> driver;
    @BeforeTest
    public void Navigate_to_the_Agreement_Screen() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "Redmi Note_7");
        dc.setCapability("udid", "b8cf3b7");
        dc.setCapability("platformVersion", "10");
        dc.setCapability("appPackage", "com.nopstation.nopcommerce.nopstationcart");
        dc.setCapability("appActivity", "com.bs.ecommerce.main.SplashScreenActivity");
        dc.setCapability("autoGrantPermissions", "true");
        URL url = new URL ("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, dc);
        System.out.println("Application started......");
        ExtentTest test = extent.createTest("NopStaion Application launched", "Will complete the three(03) different test scenarios");
        test.log(Status.INFO, "Successfully Navigated to the Read & Accept Screen");
    }
    @Test(priority = 0)
    public void Scenario_01_Customer_add_products_in_his_shopping_cart() throws Exception {
        MyScreenRecorder.startRecording("");
        ExtentTest test = extent.createTest("Scenario: 01 Customer add products in his shopping cart", "Verify the the Customers are able to add products in his/her shopping cart");
        test.log(Status.INFO, "Scenario_01 has been started....");
        //Read & Accept
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAccept")).click();
        extent.createTest("Given: Mike on home page after opening nopCart mobile app", "");
        //Swipe from left to Right
        Dimension size = driver.manage().window().getSize();
        int x = size.width;
        int y = size.height;
        int startx = x - 10;
        int starty = y / 2;
        new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800))).moveTo(PointOption.point(10, starty)).release().perform();
        extent.createTest("When: Mike click electronics from our categories list from home page", "");
        // Click
        //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RelativeLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")).click();
        extent.createTest("And: Mike click to Nokia Lumia 1020 product details page", "");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/bottom_nav_search")).click();
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/search_src_text")).sendKeys("Nokia Lumia 1020");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extent.createTest("And: Mike click to Nokia Lumia 1020 product details page", "");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/search_src_text")).click();
        extent.createTest("And: Mike click plus button to increase Qty by 2", "");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnPlus")).click();
        //Swipe Up
        Dimension sizeup = driver.manage().window().getSize();
        int w = sizeup.width;
        int h = sizeup.height;
        int startw = (int) (w / 2.0);
        int starth = (int) (h * 0.75);
        int endw = (int) (w / 2.0);
        int endh = (int) (h * 0.25);
        new TouchAction(driver).press(PointOption.point(startw, starth)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800))).moveTo(PointOption.point(endw, endh)).release().perform();
        extent.createTest("Then: Mike select size Large from product details page", "");
        extent.createTest("Mike click add to cart button to add the product in his cart", "");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart")).click();
        MyScreenRecorder.stopRecording();
    }
    @Test(priority = 1)
    public void Scenario_02_Customer_successfully_place_order_as_a_guest_user() throws Exception {
       MyScreenRecorder.startRecording("");
        ExtentTest test = extent.createTest("Scenario: 02 Customer successfully place order as a guest user", "Will also Verify that the Customers are able to successfully place order as a guest user");
        test.log(Status.INFO, "Scenario: 02 has been started");
        extent.createTest("Given: Mike go to shopping cart by clicking top cart icon", "");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/counterIcon")).click();
        //Swipe Up
        Dimension sizeup = driver.manage().window().getSize();
        int w = sizeup.width;
        int h = sizeup.height;
        int startw = (int) (w / 2.0);
        int starth = (int) (h * 0.75);
        int endw = (int) (w / 2.0);
        int endh = (int) (h * 0.25);
        new TouchAction(driver).press(PointOption.point(startw, starth)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800))).moveTo(PointOption.point(endw, endh)).release().perform();
        extent.createTest("When: Mike click checkout button from shopping cart page", "");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnCheckOut")).click();
        extent.createTest("And: Mike select checkout as guest from shopping cart page", "");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout")).click();
        extent.createTest("Then: Mike input all the details in checkout billing details page and click continue", "");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etFirstName")).sendKeys("Guest");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etLastName")).sendKeys("User");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etEmail")).sendKeys("guest.user@gmail.com");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/countrySpinner")).click();
        Thread.sleep(6000);
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etCompanyName")).sendKeys("Test Company");
        //Swipe Up
        Dimension sizeupp = driver.manage().window().getSize();
        int ww = sizeup.width;
        int hh = sizeup.height;
        int startww = (int) (w / 2.0);
        int starthh = (int) (h * 0.75);
        int endww = (int) (w / 2.0);
        int endhh = (int) (h * 0.25);
        new TouchAction(driver).press(PointOption.point(startww, starthh)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800))).moveTo(PointOption.point(endww, endhh)).release().perform();
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etCity")).sendKeys("Dhaka");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress")).sendKeys("Road:03");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etZipCode")).sendKeys("1205");
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extent.createTest("And: Mike select Next Day Air as shipping method and click continue", "");
        //driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
        //driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Placeholder\"])[8]")).click();
        Thread.sleep(3000);
        //Swipe Up
        Dimension sizeuppp = driver.manage().window().getSize();
        int www = sizeup.width;
        int hhh = sizeup.height;
        int startwww = (int) (w / 2.0);
        int starthhh = (int) (h * 0.75);
        int endwww = (int) (w / 2.0);
        int endhhh = (int) (h * 0.25);
        new TouchAction(driver).press(PointOption.point(startwww, starthhh)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800))).moveTo(PointOption.point(endwww, endhhh)).release().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
        extent.createTest("And: Mike select Check/Money Order as payment method and click continue", "");
        //Swipe Up
        Dimension sizeupppp = driver.manage().window().getSize();
        int wwww = sizeup.width;
        int hhhh = sizeup.height;
        int startwwww = (int) (w / 2.0);
        int starthhhh = (int) (h * 0.75);
        int endwwww = (int) (w / 2.0);
        int endhhhh = (int) (h * 0.25);
        new TouchAction(driver).press(PointOption.point(startwwww, starthhhh)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800))).moveTo(PointOption.point(endwwww, endhhhh)).release().perform();
        Thread.sleep(6000);
        //driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
        //Continue
        //driver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/a")).click();
        extent.createTest("And: Mike click next button on payment information page", "");
        //Next
        //driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
        extent.createTest("Then: Mike click confirm button to place the order", "");
        //Confirm
        //driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
        extent.createTest("And: Verify order place successfully with popup message Your order has been successfully processed!", "");
        Thread.sleep(9000);
        //Assert (Pop-up message verification)
        Assert.assertTrue(driver.getPageSource().contains("Your order has been successfully processed!"));
//        String  Expected_Popup_Message = "Your order has been successfully processed!";
//        String Actual_Popup_Message = driver.findElementById("com.nopstation.nopcommerce.nopstationcart:id/md_text_message").getText();
//        Assert.assertTrue(Expected_Popup_Message.equalsIgnoreCase(Actual_Popup_Message), "Expected Popup Message Mismatch");
//        test.log(Status.INFO, "Verification Succeed.");

        MyScreenRecorder.stopRecording();


    }


    @AfterTest
    public void close() {

        driver.quit();


    }






}
