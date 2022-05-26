package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSafya_ScreenShot  extends TestBase {
    @Test
    public void tumSayfaScreenShot() throws IOException {
      // Amazon a gir tum sayfanin ekran goruntusunu al
driver.get("https://www.amazon.com");
        TakesScreenshot tss= (TakesScreenshot) driver;

        // yeni ekran goruntulerini ustune kayit yapar ve eskisini siler. bunun onune gecmek
        // icin tarih formatini kullanabilirim

        LocalDateTime date=LocalDateTime.now();

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(dtf);
// kaydetmek istedigimiz directory nin dosya yolu nu yazariz
        File tumSayfaResim=new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");

        File geciciDosya= tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,tumSayfaResim);


    }
}
