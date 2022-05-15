package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Nutella {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com");
        if (driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed()) {
            System.out.println("PASSED");
            // Not : bu soru yu  5. gun videosunu izleyerek 1:50 . dk daki soruyu ya da pdf den bularak yap


        }
    }
}
