package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

public class Q4 extends TestBase {
    @Test
    public void test01() throws InterruptedException {


  //  https://www.teknosa.com/ adresine gidiniz
    driver.get("https://www.teknosa.com/");
  // arama cubuguna oppo yazip enter deyiniz

        ChromeOptions op=new ChromeOptions();
        op.addArguments("disable-popup-blocking");// NOT : CEREZLEri kapatmak icin kullanilit


        WebElement searcBox=driver.
                findElement(By.xpath("//input[@id='search-input']"));
                searcBox.sendKeys("oppo"+ Keys.ENTER);
  // sonuc sayisini yazdiriniz
        System.out.println(driver.findElement(By.xpath("//div[@class='plp-info']")).getText());
        // cikan ilk urune tiklayiniz
        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();
  // sepete ekleyiniz
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();
  // sepetime git e tiklayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();
  // consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        System.out.println(driver.findElement(By.xpath("//div[@class='cart-sum-title']")).getText());
        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();

  // son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
        System.out.println(driver.findElement(By.xpath("(//div[@class='lrl-title'])[1]")).getText());
        // driver i kapatiniz

    }
}
