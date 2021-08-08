package methodClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import testAutomation.test;
import objectRepo.object;

import static java.lang.Thread.sleep;

public class method extends test{

    public WebDriverWait wait;

    public method(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,20);
    }

    @BeforeMethod
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Cagatoy\\Desktop\\insSelenium\\Chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();

    }


    public method openPage(String value) {
        driver.get(value);
        return this;
    }
    public method click(By cl){
        driver.findElement(cl).click();
        return this;
    }
    public method sendKey(By send, String value){
        driver.findElement(send).sendKeys(value);
        return this;
    }
    public method controller (String value, By elementName){
        WebElement element = driver.findElement(elementName);
        element.getText();
        Assert.assertEquals(element.getText(),value);
        infoText("Değer Doğru Dödü" +  element.getText());
        return this;
    }

    public method infoText(String value){
        System.out.println(value);
        return this;
    }

    public method login (String email, String pass) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(object.email2));

        sendKey(object.email2,email);
        sleep(2000);
        sendKey(object.pass,pass);
        sleep(2000);
        click(object.login);
        return this;
    }

    public method controlMethod(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(object.errorText));
        controller(value,object.errorText);

        return this;
    }
}
