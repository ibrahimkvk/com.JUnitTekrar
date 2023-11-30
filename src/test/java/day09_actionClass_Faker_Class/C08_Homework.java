package day09_actionClass_Faker_Class;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C08_Homework extends TestBase {



    @Test
    public void test01() {
        // Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com");

        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> ddmenu = select.getOptions();
        for (WebElement eachddm : ddmenu
        ) {
            System.out.println(eachddm.getText());
        }

        //3- dropdown menude 28 eleman olduğunu doğrulayın
        int actualddmsayi = ddmenu.size();
        int expecteddddmsayi = 28;
        Assert.assertEquals(expecteddddmsayi, actualddmsayi);

    }

    //Test02
    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);

        //1- dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");

        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("iphone"+ Keys.ENTER);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucYazisi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="iphone";
        String actualSonucYazisi=sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));


        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkurun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        Actions actions=new Actions(driver);
        actions.click(ilkurun).perform();

        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String productTitle=driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println(productTitle);
        String productPrice= driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]")).getText();
        System.out.println(productPrice);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    }
        //Test03
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        //2-dropdown’dan bebek bölümüne secin
        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        //4-sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

        //Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }


