package Lesson13and14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[contains(@class, 'phoneNumber')]")
    private WebElement phone_number;

    public String get_a_phohe_number()
    {
        waint_elment(phone_number);
        return phone_number.getText().toString();
    }

    @FindBy(xpath = "//*[contains(text(), 'Accept cookies')]")
    private  WebElement accept_cookeies_button;
    public void click_accept_cookeies_button()
    {
        waint_elment(accept_cookeies_button);
        accept_cookeies_button.click();
    }

@FindBy(linkText = "skype")
private WebElement skype_button;

    public  void  go_to_skype_page()
    {
        waint_elment(skype_button);
        skype_button.click();
    }

    public String get_skype_button_text()
    {
        waint_elment(skype_button);
        return skype_button.getText().toString();
    }
public void waint_elment(WebElement webElement)
{
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(webElement));
}

}
