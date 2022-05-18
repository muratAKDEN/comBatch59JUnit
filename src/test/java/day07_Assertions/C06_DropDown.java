package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
    // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //  4.Tüm dropdown options'i yazdırın
    //  5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
    //  degilse False yazdırın.
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
        //driver.close();


    }
    @Test
    public void test1(){
        // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());//bir onceki adimdaki elementi yazdirir.
        //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //  4.Tüm dropdown options'i yazdırın
        List<WebElement>listOfOptions=select.getAllSelectedOptions();
        for (WebElement w:listOfOptions
             ) {
            System.out.println(w.getText());

        }
        //  5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
        //  degilse False yazdırın.

        int dropDownSize=listOfOptions.size();
        if (dropDownSize==4){
            System.out.println("true");

        }else System.out.println("false");


    }


}
