import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest {
    WebDriver driver = new ChromeDriver();

    @Step("Navigate to  <https://mex-sams-apacheweb-qa.walmart.com/login>")
    public void implementation2(String url) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        driver.get(url);

    }
    @Step("Login with id password <admin123> <12345678>")
    public void implementation1(String emailid, String pass) {
        WebDriverWait wait=new WebDriverWait(driver,20);
        String cssForemail="input#email";
        WebElement email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssForemail)));
       // WebElement email=driver.findElement(By.cssSelector("input#email"));
        WebElement password=driver.findElement(By.cssSelector("input#password"));
        WebElement submit=driver.findElement(By.cssSelector("button#buttonBlue"));

        email.sendKeys(emailid);
        password.sendKeys(pass);
        submit.click();

        String pageTitle=driver.getTitle();
        System.out.append("pageTitle::"+pageTitle);

        Assert.assertEquals("Sam's Club México, los ahorros en grande ahora online",pageTitle);






    }
}
