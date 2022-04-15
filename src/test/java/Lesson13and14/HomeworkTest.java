package Lesson13and14;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.junit.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomeworkTest {
   static WebDriver driver;
    static MainPage mainPage_andersan;

    //List<String> windowHandles;
    static JavascriptExecutor js;


    @BeforeClass
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage_andersan = new MainPage(driver);
        driver.get("https://andersenlab.com/");
       //mainPage_andersan.go_to_skype_page();
       mainPage_andersan.click_accept_cookeies_button();
         js = ((JavascriptExecutor) driver);
       // driver.findElement(By.xpath("//*[contains(text(), 'Accept cookies')]")).click();
      // new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("skype"))));
        // driver.findElement(By.linkText("skype")).click();
        System.out.println(driver.getWindowHandles());
        Set<String> windowHandles = driver.getWindowHandles() ;


    }

    @Test
    public  void chek_mobile_phone_test()
    {

       js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Assert.assertEquals("+375 17 388 40 22" , mainPage_andersan.get_a_phohe_number());
    }
    @Test
    public void check_skype_button_name()
    {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertEquals("skype",mainPage_andersan.get_skype_button_text());
    }

    @Test
    public void go_to_skype_test()
    {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    mainPage_andersan.go_to_skype_page();
        System.out.println(driver.getWindowHandles());
        List<String> windowHandles = new ArrayList(driver.getWindowHandles());
        windowHandles.add(driver.getWindowHandle());
        driver.switchTo().window(windowHandles.get(1));
        //System.out.println(driver.getCurrentUrl());
        //driver.findElement(By.linkText("skype")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://join.skype.com/aM8R4P4dNJdy"));
        Assert.assertEquals("https://join.skype.com/aM8R4P4dNJdy" ,driver.getCurrentUrl() );
        driver.close();
        driver.switchTo().window(windowHandles.get(0));



    }

    @AfterClass
    public static void Close_all()
    {driver.quit();}




}
