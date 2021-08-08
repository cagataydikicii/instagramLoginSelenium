package testAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import methodClass.method;

//
public class test {

    public WebDriver driver;
    public static String url = "https://www.instagram.com";

    @BeforeMethod
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Cagatoy\\Desktop\\insSelenium\\Chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test(description = "Login method")
    public void test() throws IndexOutOfBoundsException, InterruptedException {
        method method = new method(driver);
        String email= "x";
        String pass = "x123123123";
        method
                .openPage(url)
                .login(email,pass)
                ;
    }
    @Test(description = "Login error check method")
    public void test2() throws IndexOutOfBoundsException, InterruptedException {
        method method = new method(driver);
        String email= "x";
        String pass = "x123123123";
        String check ="Sorry, your password was incorrect. Please double-check your password.";
        method
                .openPage(url)
                .login(email,pass)
                .controlMethod(check)
        ;
    }
}
