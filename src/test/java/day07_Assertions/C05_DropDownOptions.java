package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {

    // Amazona git
    // drop down menu den books sec
    // sectigimiz option  i yazdir
    // toplam sayisinin 28 old .test edin

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

        //driver.close();

    }
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(dropDown);

        select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption().getText());
       List<WebElement> optionList= select.getOptions();
       int actualOptionSyisi=optionList.size();
       int expectedOptionSayisi=28;
        Assert.assertEquals(expectedOptionSayisi,actualOptionSyisi);


    }




}
