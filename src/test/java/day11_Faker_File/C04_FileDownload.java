package day11_Faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1. https://the-internet.herokuapp.com/download adresine git
        driver.get("https://the-internet.herokuapp.com/download");
// 2..Lambda Test   dosyasini indir
        WebElement lambdaElement=driver.findElement(By.xpath("//a[.='LambdaTest.txt']"));
        lambdaElement.click();
// 3..dosyanin basariyla inip inmedigini kontrol ediniz.
        Thread.sleep(5000);
        // dosya downloads a iner, bize downloads in path i lazim

        String farkliKisim=System.getProperty("user.home");
        System.out.println(farkliKisim);
        String ortakKisim="\\Downloads\\LambdaTest.txt";
        //  "C:\Users\akden\Downloads\LambdaTest.txt"
String dosyaYolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
