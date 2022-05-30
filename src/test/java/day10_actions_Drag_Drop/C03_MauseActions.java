package day10_actions_Drag_Drop;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MauseActions extends TestBase {

    @Test
    public void test01(){
        // 1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
       WebElement cizgiliAlan= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(cizgiliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //    test edelim.

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();




        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        String ilkSayfaWHdegeri=driver.getWindowHandle();
        Set<String>handleSeti=driver.getWindowHandles();
        String ikinciSayfaWHdegeri="";
        for (String w:handleSeti
             ) {
            if (!w.equals(ilkSayfaWHdegeri)){
            ikinciSayfaWHdegeri=w;
            }
        }
        System.out.println(handleSeti);
        driver.switchTo().window(ikinciSayfaWHdegeri);

WebElement YaziElementi2=driver.findElement(By.xpath("//h1"));
String expectedYazi2="Elemental Selenium";
String actualYazi2=YaziElementi2.getText();


Assert.assertEquals(expectedYazi2,actualYazi2);

}


}
