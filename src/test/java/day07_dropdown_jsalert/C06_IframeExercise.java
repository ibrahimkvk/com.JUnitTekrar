package day07_dropdown_jsalert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_IframeExercise {
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
        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
        int iframesayisi=iframes.size();
        System.out.println("Sayfadaki iframe sayisi: " + iframesayisi);

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement ilkframe= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(ilkframe);
        WebElement youtubelink=driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay']"));
        youtubelink.click();
        Thread.sleep(5000);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().parentFrame();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        Thread.sleep(10000);
    }
}