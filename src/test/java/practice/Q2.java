package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {
     /*
    ...Exercise2...
    http://www.bestbuy.com 'a gidin,

    Ayrica Relative Locator kullanarak;
        logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
        mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
 */
     static WebDriver driver;
    @BeforeClass
    public  static void setUp(){
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public void testenOnce(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.bestbuy.com");


    }
    @Test
    public void test(){
       // Sayfa basliginin "Best" icerdigini(contains) dogrulayin
String baslik=driver.getTitle();
        Assert.assertTrue(baslik.contains("Best"));

    }


}
