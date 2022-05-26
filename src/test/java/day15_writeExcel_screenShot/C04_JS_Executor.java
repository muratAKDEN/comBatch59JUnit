package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {
    @Test
    public void JSExecutor() {
        // normal yolla locate edemedigimiz zaman jaca script executor kullanabiliriz

// amazona gidelim
        driver.get("https://www.amazon.com");
// en asagidaki sign in butonuna JS ile scroll yapalim
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement signInButton=driver.
                findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButton);
// sign in butonuna click yapalim.
        jse.executeScript("arguments[0].click();",signInButton);


    }
}
