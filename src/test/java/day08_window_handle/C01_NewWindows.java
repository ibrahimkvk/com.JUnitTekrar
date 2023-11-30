package day08_window_handle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindows {


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

        driver.close();
    }


    @Test
    public void test01() throws InterruptedException {
        //Amazon adresine git
        driver.get("https://www.amazon.com");
        String ilkSayfaWHD= driver.getWindowHandle();
        // simdi yeni tab dan wise quarter adresine git
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        // Simdi tekrar bir onceki adrese (amazona) git ve gittigini test et
        driver.switchTo().window(ilkSayfaWHD);
        Thread.sleep(5000);
        String actualUrl=driver.getCurrentUrl();
        String expectedKelime="amazon";
        Assert.assertTrue(actualUrl.contains(expectedKelime));

    }
}
