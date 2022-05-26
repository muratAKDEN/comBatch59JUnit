package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementScreenShot extends TestBase {
    @Test
    public void WebElementSS() throws IOException {
      // amazona gidip Nutella aratalim.
      // ve sonuc sayisnin old. web elementin fotografini cekelim.
  driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement aramaSonucYazis=driver.
         findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File sonucYaziElementScreenShot=
                new File("target/ekranGoruntuleri/sonucYazisi.jpeg");
        File geciciDosya=aramaSonucYazis.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,sonucYaziElementScreenShot);


    }
}
