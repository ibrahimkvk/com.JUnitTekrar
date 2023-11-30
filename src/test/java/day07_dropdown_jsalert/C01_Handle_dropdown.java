package day07_dropdown_jsalert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Handle_dropdown {

    // Gerekli ayarlari yapin
    // 1-Amazon adresine gidin
    // 2-Arama kutusunun yanindaki dropdown menuden Books secin
    // 3-Arama butonundan Java aratin
    // 4-Title in Java icerdeigini test edin
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown() {
        //driver.close();
    }
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");

        //oncelikle dropdown menuyu locate etmemiz gerekiyor
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //simdi bir select objesi olusturuyoruz ve icinede locate ettigimiz locate yaziyoruz
        Select select=new Select(ddm);

        //sirada select objesini kullanarak istedigimiz Books elemanini seciyoruz. 3 turlu secim yapabiliriz

        //1-sececegimiz menu bastan kacinci ise  o sayiyi yaziyoruz ama saymaya
        // sifirdan basliyoruz ve 0. si genellikle select secenegi oluyor

        //select.selectByIndex(5);


        //2-sececigimiz menunun value degerini yaziyoruz  bu deger string bir deger
        //select.selectByValue("search-alias=stripbooks-intl-ship");

        //3- en kolayi sececegimiz meunun teksini yaziyoruz
        select.selectByVisibleText("Books");

        // sectigimiz menunun Books oldugunu test edelim
        WebElement actualsecilenddm=select.getFirstSelectedOption();
        String expectedkelime="Books";
        Assert.assertEquals(expectedkelime,actualsecilenddm.getText());

        // toplamda 28 tane select menu oldugunu test edin
        List<WebElement> ddmHepsi =select.getOptions();
        Assert.assertEquals(28,ddmHepsi.size());

        // simdi arama kutusuna java yazabiliriz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);


        //title in Java icerdigini test edelim
        String expectedKelime="Java";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedKelime));

    }

}
