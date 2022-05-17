package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
       amazon ana sayfaya gidin
       3 farkli test method'u olusturarak asagidaki gorevleri yapin
       1- Url'in amazon icerdigini test edin
       2- title'in facebook icermedigini test edin
       3- sol ust kosede amazon logosunun gorundugunu test edin
        */
    static WebDriver driver;

    @BeforeClass
    public static void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");


    }

    @AfterClass
    public static void tearDown() {


        driver.close();

    }

    @Test
    public void test1() {
       // 1- Url'in amazon icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));



    }
    @Test
    public void test2(){
        //2- title'in facebook icermedigini test edin

        Assert.assertFalse(driver.getCurrentUrl().contains("facebook"));

    }
    @Test
    public  void test3(){
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());


    }



}// Class
