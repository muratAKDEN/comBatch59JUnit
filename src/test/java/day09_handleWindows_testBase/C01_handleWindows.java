package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
    WebDriver driver;
  @Before
  public void setUp(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


  }
  @After
    public void tearDown(){

      driver.close();
  }
    @Test
    public void test() throws InterruptedException {
      // amazona git
        driver.get("https://www.amazon.com");
        System.out.println(driver.getWindowHandle());// hash kodunu print eder

        //CDwindow-EAA328464A7415199A3307348B3F9BD9
        // bu kod sayfanin hash kodu olup, selenium sayfalar arasi geciste bu kodu kullanir.
      /*
        CDwindow-4062F2D78BD37C7921FEBC32A9B51C74
        bu kod acilan sayfanin unique hash kodudur.
        Selenium sayfalar arasi geciste bu window handle degerini kullanir
        eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfaya gecemek istiyorsak
        driver.switchTo().window("CDwindow-4062F2D78BD37C7921FEBC32A9B51C74");
        bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz.
         */


        // nutella ara
        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);



        //cikan ilk urunu yebi sekmede ac
        WebElement ilkUrunResmi=driver.
         findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));


        driver.switchTo().newWindow(WindowType.TAB);
          /*
        Bu komutu kullandigimizda driver otomatik olarak olusturulan
        new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);



        ilkUrunResmi=driver.
                findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
ilkUrunResmi.click();
        // yeni urunun title i ni yazdir.
        WebElement ilkUrumBaslik=driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(ilkUrumBaslik.getText());
        System.out.println(driver.getCurrentUrl());
        // ilk sayfa ya gidip url i yazdir
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());


    }





}// Class
