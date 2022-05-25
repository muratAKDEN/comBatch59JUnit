package day13_Cookies_webTables;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01Cookies extends TestBase {

    @Test
    public void cookiesTesti() {
        // 1- Amazon anasayfaya gidin
       driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie>setOfCookies =driver.manage().getCookies();
        System.out.println(setOfCookies);
        int sayac=1;

        for (Cookie w:setOfCookies
             ) {
            System.out.println(sayac+". Cookie: "+w);
            sayac++;
        }
//3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
int cookiesSayisi=setOfCookies.size();
        Assert.assertTrue(cookiesSayisi>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:setOfCookies
             ) {
            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }

        }


        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan
        // bir cookie olusturun ve sayfaya ekleyin
Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        setOfCookies =driver.manage().getCookies();
        System.out.println(setOfCookies);
         sayac=1;

        for (Cookie w:setOfCookies
        ) {
            System.out.println(sayac+". Cookie: "+w);
            sayac++;
        }


        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(setOfCookies.contains(cookie));



//7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(setOfCookies.contains("skin"));
//8- tum cookie’leri silin ve silindigini test edin
driver.manage().deleteAllCookies();
        setOfCookies =driver.manage().getCookies();
        Assert.assertTrue(setOfCookies.isEmpty());

    }
}
