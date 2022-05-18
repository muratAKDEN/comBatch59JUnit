package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {

    // Bir Class olusturalim YanlisEmailTesti
    //http://automationpractice.com/index.php sayfasina gidelim
    //Sign in butonuna basalim
    //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
    //   “Invalid email address” uyarisi ciktigini test edelim

    static WebDriver driver;

    @BeforeClass
    public static void setUp (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));



    }
    @AfterClass
    public static void tearDown(){
        driver.close();


    }

    @Test
    public void test(){
        // Bir Class olusturalim YanlisEmailTesti
        //http://automationpractice.com/index.php sayfasina gidelim
        //Sign in butonuna basalim
        //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
        //   “Invalid email address” uyarisi ciktigini test edelim

        driver.get("http://automationpractice.com/index.php");

        //Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
        //   “Invalid email address” uyarisi ciktigini test edelim
        WebElement mailKutusu=driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("muratgmail.com" + Keys.ENTER);
        WebElement uyariYazisiElementi=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyariYazisiElementi.isDisplayed());
    }





}
