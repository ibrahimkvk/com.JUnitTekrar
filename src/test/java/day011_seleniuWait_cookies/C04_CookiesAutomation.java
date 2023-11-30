package day011_seleniuWait_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_CookiesAutomation extends TestBase {
    @Test
    public void CookiesAutomation() {
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> tumCookies=driver.manage().getCookies();

         /*
         int sirano=1;

        for (Cookie eachcookies:tumCookies
             ) {
            System.out.println(sirano + "-" +eachcookies);
            sirano=sirano+1;
        }
         */
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("sayfadaki tum cookies lerin sayisi  " + tumCookies.size());

        Assert.assertTrue(tumCookies.size()>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedValue="USD";
        String actualValue="";
        for (Cookie eachCookies: tumCookies
             ) {
            if(eachCookies.getName().equals("i18n-prefs")) {
                actualValue=eachCookies.getValue();
            }
        }
        Assert.assertEquals(expectedValue,actualValue);


        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin

        Cookie myCookiem=new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(myCookiem);
        tumCookies=driver.manage().getCookies();
        int sirano=1;
        for (Cookie eachcookies:tumCookies
        ) {
            System.out.println(sirano + "-" +eachcookies);
            sirano=sirano+1;
        }


        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        int cikolataliCookieSayisi=0;
        for (Cookie eachCookies: tumCookies
        ) {
            if(eachCookies.getName().equals("en sevdigim cookie")) {
                cikolataliCookieSayisi=cikolataliCookieSayisi+1;
            }
        }
        Assert.assertTrue(cikolataliCookieSayisi>0);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");
        tumCookies=driver.manage().getCookies();
        int USDCookieSayisi=0;
        for (Cookie eachCookies: tumCookies
        ) {
            if(eachCookies.getName().equals("skin")) {
                USDCookieSayisi=USDCookieSayisi+1;
            }
        }
        Assert.assertEquals(0,USDCookieSayisi);

    //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookies=driver.manage().getCookies();

        System.out.println("########################################################################");
         sirano=1;
        for (Cookie eachcookies:tumCookies
        ) {
            System.out.println(sirano + "-" +eachcookies);
            sirano=sirano+1;
        }

        Assert.assertEquals(0,tumCookies.size());
    }
}