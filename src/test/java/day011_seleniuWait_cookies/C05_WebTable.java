package day011_seleniuWait_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C05_WebTable extends TestBase {
    @Test
    public void test01() {
        // 1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin
        Actions action=new Actions(driver);
        action.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(3);

        //3.Web table tum body’sini yazdirin
        WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        //4.Web table’daki satir sayisinin 7 oldugunu test edin
        List<WebElement> birinciSutunElemanlari=driver.findElements(By.xpath("//tbody/tr/td[1]"));
        Assert.assertEquals(7,birinciSutunElemanlari.size());
        System.out.println("#################################################################");

        //5.Tum satirlari yazdirin
        List<WebElement> tumSatirlar=driver.findElements(By.xpath("//tbody/tr"));

        for (WebElement eachRow:tumSatirlar
             ) {
            System.out.println(eachRow.getText());
        }

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> birinciSatirSutunElemanlari=driver.findElements(By.xpath("//tbody/tr[1]/td"));
        Assert.assertEquals(13,birinciSatirSutunElemanlari.size());
        System.out.println("#############################################################");

        //7. 5.sutunu yazdirin
        List<WebElement> besinciSutun=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement eachBesinciSutun:besinciSutun
             ) {
            System.out.println(eachBesinciSutun.getText());
        }


        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
        //döndüren bir method olusturun

        System.out.println("++++++++++++++++++++++++++++++++++++++++++");

        WebElement istenenDataElementi=getElement(5,5);
        System.out.println(istenenDataElementi.getText());

    }
    private WebElement getElement(int satir, int sutun) {
        String dinamikXpath="//tbody/tr["+ satir+ "]/td["+ sutun + "]";
        WebElement istenenElement =driver.findElement(By.xpath(dinamikXpath));

        return istenenElement;
    }

}
