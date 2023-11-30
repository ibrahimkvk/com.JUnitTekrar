package day07_dropdown_jsalert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_JSalert {
    // Gerekli ayarlamalari yapin
    // https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // 3 test metodu olusturup her metodda farkli bir jsalerte basin
    // ilgili metodlari kullanin
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void teardown()
    {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1. alert tusuna basalim
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //aleryin uzerindeki yazinin "I am a JS Alert" oldugunu test edelim
        String JSalertYazi= driver.switchTo().alert().getText();
        String expectedYazi="I am a JS Alert";
        Assert.assertEquals(expectedYazi,JSalertYazi);

        // okey e basip alerti  kapatalim
        driver.switchTo().alert().accept();

        // aleri kapattigimizda "You successfully clicked an alert" yazisi ciktigini test edelim
        WebElement yazi= driver.findElement(By.id("result"));
        String expectedCumle="You successfully clicked an alert";
        String ActualCumle=yazi.getText();
        Assert.assertEquals(expectedCumle,ActualCumle);
    }
    @Test
    public void test02() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 2. alert  tusuna basalim
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        //cikan cancel tusuna basalim
        driver.switchTo().alert().dismiss();

        // sayfada "You clicked: Cancel" yazisi ciktigini test edelim
        String actualsonuc=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedsonuc="You clicked: Cancel";
        Assert.assertEquals(expectedsonuc,actualsonuc);
    }
    @Test
    public void test03() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 3.alerte basalim
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        // cikan yere aAbdullah yazalim okeye basalim
        driver.switchTo().alert().sendKeys("Abdullah");
        driver.switchTo().alert().accept();

        // cikan sonuc yazisinin Abdullah icerdigini test edelim
        String actualSonuc=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedSonuc="Abdullah";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

    }



}
