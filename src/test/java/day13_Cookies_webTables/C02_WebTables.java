package day13_Cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    @Test
    public void webTable() {
        //● login( ) metodun oluşturun ve oturum açın.
        girisYap();
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //          ○ Username : manager
        //          ○ Password : Manager1!


        //          ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun Sayisi :  "+sutunSayisi.size());

//          ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        // not : tr --> table row -->tablo satiri
        //        td==> table data---> tablodaki datalar


        // NOT:  Tum body'i bir String olarak yazdirmak isterseniz,
        // body webElementini locate edip, getText() method'u ile yazdirabilirsiniz

        //● printRows( ) metodu oluşturun //tr
        //          ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
List<WebElement>satirlarListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir Sayisi : "+satirlarListesi.size());
        //          ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w:satirlarListesi
             ) {
            System.out.println(w.getText());
        }

        //         4 ncu satirdaki td (table data:) elementleri konsolda yazdırın.
List<WebElement>dataSayisi=driver.findElements(By.xpath("//tbody//tr[4]//td"));

        for (WebElement w:dataSayisi
             ) {
            System.out.println(w.getText());
        }
        //          Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
        List<WebElement>basliklarListesi=driver.findElements(By.xpath("//tbody//tr[1]//th"));
        int emailNO=0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
              emailNO=i;
            }

        }

        List<WebElement>emailSutunListesi=
                driver.findElements(By.xpath("//tbody//td["+(emailNO+1)+"]"));
        for (WebElement w:emailSutunListesi
             ) {
            System.out.println(w.getText());
        }
    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement userName=driver.findElement(By.xpath("//input[@name='UserName']"));
        actions.click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();


    }
}