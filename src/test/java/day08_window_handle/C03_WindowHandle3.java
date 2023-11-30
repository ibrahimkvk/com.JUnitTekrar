package day08_window_handle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandle3 {

    // https://the-internet.herokuapp.com/iframe adresine gidin
    // elemental selenium linkini tiklayin
    // Acilan sayfadaki en buyuk yazinin  Elemental Selenium oldugunu test edin
    // ilk sayfaya geri donup sayfadaki yazinin
    // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin
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
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkSayfaWHD=driver.getWindowHandle();

        // elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();


        // Acilan sayfadaki en buyuk yazinin  "Make sure your code lands" oldugunu test edin
        Set<String> tumWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String eachWHD:tumWHD
             ) {
            if(!eachWHD.equals(ilkSayfaWHD)) {
                ikinciSayfaWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);
        String actualsayfadakiEnBuyukYazi=driver.findElement(By.xpath("//h1[@class='home-header']")).getText();
        String expectedsaydakiEnBuyukYazi="Make sure your code lands";
        Assert.assertEquals(expectedsaydakiEnBuyukYazi,actualsayfadakiEnBuyukYazi);

        // ilk sayfaya geri donup sayfadaki yazinin
        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin
        driver.switchTo().window(ilkSayfaWHD);

        String  actualilkSayfaYazisi=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        String expectedIlkSayfaYazisi="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(expectedIlkSayfaYazisi,actualilkSayfaYazisi);
        Thread.sleep(5000);












    }
}
