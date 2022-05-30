package practice.day3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Alert extends TestBase {

    @Test
    public void test01() {

        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();


        //    accept Alert(I am an alert box!) and print alert on console
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.switchTo().alert().dismiss();
        //    cancel Alert  (Press a Button !)
        driver.findElement(By.xpath("//a[@class='analystic']")).click();
        driver.switchTo().alert().dismiss();
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        //    finally print on console this message "Hello TechproEducation How are you today"
        //    aseertion these message

    }
}
