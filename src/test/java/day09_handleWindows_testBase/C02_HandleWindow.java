package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindow {


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {

       driver.quit();
    }

    @Test
    public void test01() {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
// 2- url'in  amazon icerdigini test edelim
        String wantedWord = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(wantedWord));

// 3- yeni bir pencere acip Best Buy ana sayfaya gidelim

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.bestbuy.com");

        String ikinciSayfaHandleDegeri = driver.getWindowHandle();
// 4- title'in "Best Buy" icerdigini test edelim
        String actualTitleName = driver.getTitle();
        Assert.assertTrue(actualTitleName.contains("Best Buy"));


// 5- ilk sayfaya donup
// ( elimizde handle degeri olmak zorunda)
        // NOT : yeni sekmeden eski sekmeye gelmek icin window hamdle degeri ne ihtiyac vardir
        // o yuzden actigimiz her sekme nin handle degerini ihtiyaten alabiliriz
        driver.switchTo().window(ilkSayfaHandleDegeri);

        //sayfada java aratalim

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);


// 6- arama sonuclarinin Java icerdigini test edelim
        WebElement aramaSonucu=driver.
          findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiStr=aramaSonucu.getText();
        Assert.assertTrue(sonucYazisiStr.contains("Java"));


// 7- yeniden Best Buy'in acik oldugu sayfaya gidelim

        driver.switchTo().window(ikinciSayfaHandleDegeri);


// 8- logonun gorundugunu test edelim
        WebElement logoElement=driver.
                findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElement.isDisplayed());




    }


}
