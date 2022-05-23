package day12_synchoronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait  extends TestBase {
   // 2 method olustur : implicitWait() , explicitWait()
    //iki metgod icin asagidaki adimlari test edin


    @Test
    public void impicitlyWaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
WebElement goneYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(goneYazisi.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement backYazisi=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
Assert.assertTrue(backYazisi.isDisplayed());
    }

    @Test
    public void explicitlyWaitTesti() {

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement itsGoneYaziElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());
        yazinin gorunur olmasini beklerken yazinin locate'ini kullanmak sorun olusturur
        cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir
        (HTML kodlari yazan developer farkli uygulamalar yapablir)
        Bu durumda bekleme islemi ve locate'i birlikte yapmaliyiz
        */
        WebElement itsGoneYaziElementi=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackElementi.isDisplayed());
    }



    }

