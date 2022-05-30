package day10_actions_Drag_Drop;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Keyboard_Actions extends TestBase {

 @Test
 public void test01(){
     driver.get("https://www.anazon.com");
     WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
     //arama kutusuna click yap (keyboard ile)
     Actions actions=new Actions(driver);
     actions.click(searchBox).perform();


     // harf harh NUTella yaz


     actions.keyDown(Keys.SHIFT).
            sendKeys("nut").
                     keyUp(Keys.SHIFT).
                                 sendKeys("ella").perform();
             // enter yap.

actions.sendKeys(Keys.ENTER).perform();
 }



}
