package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01 {

     /*
    ...Exercise1...
    BeforeClass ile driver ı olusturun ve class icinde static yapin
    Maximize edin, 15 sn bekletin

    AfterClass ile kapatın
 */
    static WebDriver driver;
    @BeforeClass
    public  static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Before
    public void testenOnce(){
        //  http://www.google.com adresine gidin
        driver.get("https://www.google.com");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();

    }
    @Test
    public void test01(){
        //  arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin

        WebElement aramaKutusu=driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("Green Mile");
        aramaKutusu.submit();




    }
    @After
    public void testenSonra(){
        WebElement aramaSonucSayisi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(aramaSonucSayisi.getText());


    }
    @Test
    public void test02(){
        //  arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin

        WebElement aramaKutusu=driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("Premonition");
        aramaKutusu.submit();





    }
    @Test
    public void test03(){
        //  arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu=driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("The Curious Case of Benjamin Button");
        aramaKutusu.submit();


    }






}
