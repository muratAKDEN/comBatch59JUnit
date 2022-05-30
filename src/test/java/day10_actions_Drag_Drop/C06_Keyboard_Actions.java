package day10_actions_Drag_Drop;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_Keyboard_Actions extends TestBase {

    @Test
    public void test01() {

        // facebook ana sayfaya git
        driver.get("https://www.facebook.com");
        // yeni kayit olustur
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"))
                .click();
        // isim kutusunu locate et
      WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

        // geriye kalan alanlari tab ile dolasarak formu doldur.
Actions actions=new Actions(driver);
actions.click(isimKutusu).sendKeys("Murat").
        sendKeys(Keys.TAB).
        sendKeys("Akdeniz").
        sendKeys(Keys.TAB).perform();


    }
}
