package practice.day3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Iframe extends TestBase {

    @Test
    public void test01() {

    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
   driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
    // ikinci emojiye tıklayın
        driver.findElement
                (By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
    // tüm ikinci emoji öğelerini tıklayın

    // parent iframe e geri donun
    // formu doldurun,(Formu istediğiniz metinlerle doldurun)
    //  apply button a basin

    }
}
