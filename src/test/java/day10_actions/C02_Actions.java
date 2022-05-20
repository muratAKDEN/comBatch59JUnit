package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase{

    @Test
    public void test01() throws InterruptedException {
        // amazon ana sayfaya gidip
        // accoun menusunden create a lis linkine tikla
       driver.get("https://www.amazon.com");
        Actions actions =new Actions(driver);
        WebElement accountLİnk=driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        actions.moveToElement(accountLİnk).perform();// mouse u oraya oturup bekler
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='nav-text'])[1]")).click();


    }

}
