package day08_Alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Iframe {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @After
    public void TearDown() {
        // driver.close();


    }

    @Test
    public void test() throws InterruptedException {

        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //      ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
        //      ve  konsolda    yazdirin.
        WebElement baslikElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());

        //      ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeelementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeelementi);

        WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(2000);
        textBox.clear();
        Thread.sleep(2000);
        textBox.sendKeys("Merhaba Dunya!");


    /* textbox'i dogru olarak locate etmemize ragmen driver bulamadi
     bunun uzerine HTML kodlari inceleyince
     textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
     bu durumda once iframe'i locate edip
     switchTo() ile o iFrame'e gecmeliyiz

     */
        //      ○ TextBox’in altinda bulunan “Elemental Selenium”
        //      linkinin textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

        // iframeden cikmadan bulamaz
        driver.switchTo().defaultContent();//default Conten eski haline getirir
        WebElement linkYazi=driver.findElement(By.linkText("Elemental Selenium"));


        Assert.assertTrue(linkYazi.isDisplayed());
        System.out.println(linkYazi.getText());


    }

}
