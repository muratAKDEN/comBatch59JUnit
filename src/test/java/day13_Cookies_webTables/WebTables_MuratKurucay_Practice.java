package day13_Cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTables_MuratKurucay_Practice extends TestBase {
    @Test
    public void test01() {
        // https://demoqa.com/webtables sayfasina gidin
driver.get("https://demoqa.com/webtables");
        //sutunun basligini yazdir
        List<WebElement>headersList=driver
                .findElements(By.xpath("//div[@class='rt-resizable-header-content']"));

        int sizeOfDepatment=1;
        for (int i = 0; i <headersList.size() ; i++) {
            System.out.println(sizeOfDepatment + " . sutun  baslik " + headersList.get(i).getText());
            sizeOfDepatment++;
        }
        sizeOfDepatment=0;
        for (int i = 0; i < headersList.size(); i++) {
            if (headersList.get(i).getText().equals("Department")){
                sizeOfDepatment=i;

            }


        }
         sizeOfDepatment++;
        System.out.println("index Of Department:  "+sizeOfDepatment);
        //Headersda buluman department isimleri ni yazdir
        List<WebElement>DepartmentIsimleri=driver
                .findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td']["+sizeOfDepatment+"]"));
        for (int i = 0; i <DepartmentIsimleri.size() ; i++) {
            if (!DepartmentIsimleri.get(i).getText().equals(" ")){
            System.out.println(DepartmentIsimleri.get(i).getText());}
        }
        System.out.println("******");
        // 3ncu sutunun basligini yazdir
        System.out.println(headersList.get(2).getText());

        // Tablodaki tum datalari yazdir
        WebElement tumDatalar=driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println(tumDatalar.getText());

        // tabloda kac cell(data) oldugunu yazdir .
        List<WebElement>cellSAyisi=driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("cellSAyisi.size() = " + cellSAyisi.size());
        //Tablo daki satir sayisini yazdir
List<WebElement>satirSayisi=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("satir Sayisi = " + satirSayisi.size());
        // Tablo daki  sutun sayisini yazdir
List<WebElement>sutunSayisi=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println("sutun Sayisi = " + sutunSayisi.size());
        // 3. kolonu yazdir
        List<WebElement>ucuncuKolon=driver.
                findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
        for (int i = 0; i <ucuncuKolon.size() ; i++) {
            System.out.println("3. kolon : "+ucuncuKolon.get(i).getText());

        }



        // First name Kierra olan kisinin Salary sini yazdir

       List<WebElement>isimlerList=
               driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][1]") );

       List<WebElement>salaryList=
               driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][5]") );
        for (int i = 0; i <isimlerList.size() ; i++) {
            if (isimlerList.get(i).getText().equals("Kierra")){
                System.out.println(salaryList.get(i).getText());
            }
        }

        // satir ve sutun sayisini girdigimde bana detayi yazdirsin.
        int satir=2;
        int sutun=2;

        WebElement istenenCell=driver
                .findElement(By.xpath("//div[@class='rt-tr-group']["+satir+"]//div[@class='rt-td']["+sutun+"]"));
        System.out.println(istenenCell.getText());

    }


}
