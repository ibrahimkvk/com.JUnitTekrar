package day05_jUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver=new ChromeDriver();
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setup metodu calisti");
    }
    @After
    public void tearDown() {
        System.out.println("tearDown metodu calisti");
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
    @Test
    public void test03() throws InterruptedException {
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
}
