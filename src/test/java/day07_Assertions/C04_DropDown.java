package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDown {
    // Amazona git
    // dropdowdan books secenegini sec
    // Java arat ve
    // arama sonuclerinin Java icerdigini test ediniz


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After

    public void tearDown() {

        driver.close();

    }

    @Test
    public void test1() {
        driver.get("https://www.amazon.com");
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));


        Select select = new Select(dropDownMenu);

        select.selectByVisibleText("Books");
        // select.selectByIndex(5);
        //select.selectByValue("search-alias=stripbooks-intl-ship");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);
        WebElement sonucYazisi = driver.
                findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiElementi_Str = sonucYazisi.getText();
        String arananKelime = "Java";


        Assert.assertTrue(sonucYazisiElementi_Str.contains(arananKelime));

    }


}