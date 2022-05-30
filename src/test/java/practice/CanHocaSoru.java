package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class CanHocaSoru extends TestBase {
    @Test
    public void test01() {

        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
       WebElement urunler=driver.findElement(By.xpath("//div[@class='sc-uhudcz-0 iZZGui']"));
      List<WebElement>urunlistesi=new ArrayList<>();
  urunlistesi.add(urunler);
     System.out.println(urunler);


WebElement gh=driver.findElement(By.xpath("//div[@class='sc-uhudcz-0 iZZGui']"));
String er=gh.getText();
     System.out.println(er);

// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
// (Her ürün 1 defadan fazla eklenemez!)
// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
// 7.Checkout'a tıklayın



    }
}
