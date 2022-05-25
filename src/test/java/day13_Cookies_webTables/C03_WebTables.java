package day13_Cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WebTables extends TestBase {
    @Test
    public void dinamikYazici() {
        // onceki Class daki adreswe gidip
        // girisYap methodunu kullanarak sayfaya giris yap
        // input olarak verilen satir sayisi ve sutun sayisi na sahip cell deki text i yazdir.
        int satir=3;
        int sutun=5;
       girisYap();
WebElement arananCell=
        driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));

    }
    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement userName=driver.findElement(By.xpath("//input[@name='UserName']"));
        actions.click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();


    }
}
