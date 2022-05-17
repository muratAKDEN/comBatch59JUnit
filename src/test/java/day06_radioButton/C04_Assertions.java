package day06_radioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;
    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After
    public void tearDown(){


        driver.close();
    }

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
// https://www.facebook.com adresine git
/*


if (driver.getCurrentUrl().equals("https://www.facebook.com")){
    System.out.println("PASSED");
}else System.out.println("Failed");

*/
String expectedUrl="https://www.facebook.com";
String actualdUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualdUrl);

    }











}
