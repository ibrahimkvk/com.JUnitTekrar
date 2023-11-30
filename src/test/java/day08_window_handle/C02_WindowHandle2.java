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

// Tests package’inda yeni bir class olusturun: WindowHandle2
public class C02_WindowHandle2 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown() {

        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String  ilkSayfaWHD=driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String  actualsayfaYazisi=driver.findElement(By.tagName("h3")).getText();
        String expectedsayYazisi="Opening a new window";
        Assert.assertEquals(expectedsayYazisi,actualsayfaYazisi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualSayfaTitle=driver.getTitle();
        String expectedSayfaTitle="The Internet";
        Assert.assertEquals(expectedSayfaTitle,actualSayfaTitle);
        Thread.sleep(5000);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set <String> tumWHD=driver.getWindowHandles();
        String ikinciWHD=" ";
        for (String eachWHD:tumWHD
             ) {
            if(!eachWHD.equals(ilkSayfaWHD)) {
                ikinciWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciWHD);
        String actualTitle2=driver.getTitle();
        String expectedTitle2="New Window";
        Assert.assertEquals(expectedTitle2,actualTitle2);
        Thread.sleep(5000);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualyeniYazi=driver.findElement(By.tagName("h3")).getText();
        String  expectedyeniYazi="New Window";
        Assert.assertEquals(expectedyeniYazi,actualyeniYazi);
        Thread.sleep(5000);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
         String actualTitle3=driver.getTitle();
         String expectedTitle3="The Internet";
        Assert.assertEquals(expectedTitle3,actualTitle3);
        Thread.sleep(5000);

    }


}
