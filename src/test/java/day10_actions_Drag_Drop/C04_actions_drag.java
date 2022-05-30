package day10_actions_Drag_Drop;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_actions_drag extends TestBase {
  /*  Yeni bir class olusturalim: MouseActions2

   */
    @Test
    public void test01(){
   //  1- https://demoqa.com/droppable adresine gidelim
      driver.get("https://demoqa.com/droppable");
   //  2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
      Actions actions=new Actions(driver);
    WebElement sourceElement=driver.findElement(By.xpath("//div[@id='draggable']"));
    WebElement targetElement=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
    actions.dragAndDrop(sourceElement,targetElement).perform();
   //  3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
      WebElement drpoppedYazisi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
      Assert.assertTrue(drpoppedYazisi.isDisplayed());
      Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());




    }

}
